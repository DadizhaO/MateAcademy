package Lesson17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {
    private static EntityManagerFactory factory;

    static {
        String persistenceUnitName;
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Set<Order> getAllOrdersInnerJoin() throws SQLException {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOrder(Order order) throws SQLException {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
            LOG.debug("persist successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            LOG.error("failed", re);
            throw re;
        }

    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(Order order) throws SQLException {
        return false;
    }
}
