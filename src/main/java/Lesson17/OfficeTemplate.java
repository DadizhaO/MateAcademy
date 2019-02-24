package Lesson17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface OfficeTemplate {
    Logger LOG = LogManager.getLogger();

    default boolean operationTemplate(EntityManager entityManager) {

        try {
            entityManager.getTransaction().begin();
            returnEntityManager(entityManager);
            entityManager.getTransaction().commit();
            LOG.debug("successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            LOG.error("failed", re);
            throw re;
        }
    }

    void returnEntityManager(EntityManager entityManager);
}
