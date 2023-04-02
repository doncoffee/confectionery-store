package by.academy.dao.impl;

import by.academy.dao.DAO;
import by.academy.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static by.academy.util.constants.Constants.*;

public class DAOImpl<T> implements DAO<T> {
    private final Class<T> clazz;

    public DAOImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T create(T object) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(object);

        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    @Override
    public List<T> read() {
        List<T> list;
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(FROM + clazz.getSimpleName());
        list = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }

    @Override
    public T update(T object) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(object);

        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.find(clazz, id));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T selectById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        T object = entityManager.find(clazz, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    @Override
    public List<T> findAllByPageAndSearch(Integer currentPage, Integer itemsPerPage, String searchQuery) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(clazz);
        Root<T> root = criteria.from(clazz);

        criteria.select(root);

        if (searchQuery != null && !searchQuery.isEmpty()) {
            Predicate searchPredicate = createSearchPredicate(cb, root, searchQuery);
            criteria.where(searchPredicate);
        }

        criteria.orderBy(cb.asc(root.get(ID)));
        TypedQuery<T> typedQuery = em.createQuery(criteria);
        int offset = (currentPage - 1) * itemsPerPage;
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(itemsPerPage);
        List<T> resultList = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public Integer getNumberOfRows(String searchQuery) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<T> root = criteria.from(clazz);

        criteria.select(builder.count(root));

        if (searchQuery != null && !searchQuery.isEmpty()) {
            Predicate searchPredicate = createSearchPredicate(builder, root, searchQuery);
            criteria.where(searchPredicate);
        }

        Long count = em.createQuery(criteria).getSingleResult();

        em.getTransaction().commit();
        em.close();
        return count.intValue();
    }

    /**
     * Creates a search predicate to search for entities that match any of the given search terms in their
     * string or number fields.
     *
     * @param cb           the criteria builder to use to create the predicates
     * @param root         the root of the criteria query
     * @param searchQuery  the search query containing the search terms
     * @return a predicate that can be used to filter entities based on the search terms
     */
    private Predicate createSearchPredicate(CriteriaBuilder cb, Root<T> root, String searchQuery) {
        String[] searchTerms = searchQuery.split(REGEX);
        List<Predicate> searchPredicates = new ArrayList<>();
        for (String term : searchTerms) {
            List<Predicate> fieldPredicates = new ArrayList<>();
            for (SingularAttribute<? super T, ?> attribute : root.getModel().getDeclaredSingularAttributes()) {
                Class<?> attributeType = attribute.getJavaType();
                if (attributeType.equals(String.class)) {
                    fieldPredicates.add(cb.like(cb.lower(root.get(attribute.getName())),
                            LIKE_EXPRESSION + term.toLowerCase() + LIKE_EXPRESSION));
                } else if (Number.class.isAssignableFrom(attributeType)) {
                    try {
                        Number number = NumberFormat.getInstance().parse(term);
                        fieldPredicates.add(cb.equal(root.get(attribute.getName()), number));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            searchPredicates.add(cb.or(fieldPredicates.toArray(new Predicate[0])));
        }
        return cb.and(searchPredicates.toArray(new Predicate[0]));
    }

}
