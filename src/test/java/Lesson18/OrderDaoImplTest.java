package Lesson18;

import Lesson17.Order;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class OrderDaoImplTest {
    private OrderDaoImpl orderDao = new OrderDaoImpl();

    private static final Order ORDER = new Order(BigDecimal.valueOf(1234), null, null, null, null, null,
            null, null);

    @Test
    public void testGetAllOrders() {
        Set<Order> orders = orderDao.getAllOrders();

        orders.forEach(System.out::println);
        assertTrue(orders.size() > 0);
    }

    @Test
    public void testFindOrderById() {
        Order order = orderDao.findOrderById(new BigDecimal(113036));
        System.out.println(order);
        assertNotNull(order);
    }

    @Test
    public void testInsertOrder() {
        assertTrue(orderDao.insertOrder(ORDER));
    }

    @Test
    public void testUpdateOrder() {
        ORDER.setAmount(BigDecimal.valueOf(1111));
        ORDER.setQty(BigDecimal.valueOf(222));
        assertTrue(orderDao.updateOrder(ORDER));
    }

    @Test
    public void testDeleteOrder() {
        assertTrue(orderDao.deleteOrder(ORDER));
    }
}