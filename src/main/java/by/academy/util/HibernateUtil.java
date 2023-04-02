package by.academy.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static by.academy.util.constants.Constants.PERSISTENCE_UNIT_NAME;

public class HibernateUtil {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    public static void close() {
        FACTORY.close();
    }
}
