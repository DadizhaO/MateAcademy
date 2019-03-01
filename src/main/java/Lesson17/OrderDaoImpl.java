package Lesson17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {
    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<Order> getAllOrders() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Order> cq = cb.createQuery(Order.class);
            Root<Order> rootEntry = cq.from(Order.class);
            CriteriaQuery<Order> all = cq.select(rootEntry);
            TypedQuery<Order> allQuery = entityManager.createQuery(all);
            allQuery.setFirstResult(1);
            allQuery.setMaxResults(1);
            return new HashSet<>(allQuery.getResultList());
        } catch (RuntimeException re) {
            LOG.error("getAll failed", re);
            throw re;
        }

    }


    @Override
    public Order findOrderById(BigDecimal id) {
        //LOG.debug("getting Orders instance with id: " + id);
        try {
            Order order = entityManager.find(Order.class, id);
            //LOG.debug("successful");
            return order;
        } catch (RuntimeException re) {
            // LOG.error("failed", re);
            throw re;
        }
    }

    @Override
    public boolean insertOrder(Order order) {

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
    public boolean updateOrder(Order order) {
        try {
            entityManager.getTransaction().begin();

            Order order2 = entityManager.find(Order.class, order.getOrderNum());
            order2.setQty(new BigDecimal(123));
            order2.setAmount(new BigDecimal(123));
            entityManager.merge(order2);
            entityManager.getTransaction().commit();
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
    public boolean deleteOrder(Order order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.getReference(Order.class, order.getOrderNum()));
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            LOG.error("failed", re);
            throw re;
        }
    }
}
