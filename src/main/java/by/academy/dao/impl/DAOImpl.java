package by.academy.dao.impl;

import by.academy.dao.DAO;
import by.academy.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class DAOImpl<T> implements DAO<T> {
    public static final String FROM = "FROM ";
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
    public List<T> findAllByPage(Integer currentPage, Integer itemsPerPage) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(clazz);
        Root<T> root = criteria.from(clazz);

        criteria.select(root);
        criteria.orderBy(cb.asc(root.get("id")));
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
    public Integer getNumberOfRows() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        Root<T> root = criteria.from(clazz);

        Integer size = em.createQuery(criteria).getResultList().size();

        em.getTransaction().commit();
        em.close();
        return size;
    }
}
