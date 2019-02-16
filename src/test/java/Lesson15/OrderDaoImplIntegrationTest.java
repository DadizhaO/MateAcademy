package Lesson15;


import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderDaoImplIntegrationTest {


    private OrderDao orderDao = new OrderDaoImpl();
    static Order order = new Order
            (new BigDecimal(1234), null, LocalDate.of(1999, 12, 13), "mfr", new BigDecimal(12), new BigDecimal(123.12));

    @Test
    public void testFindOrderById() throws SQLException {
        Order order = orderDao.findOrderById(new BigDecimal(112922));
        System.out.println(order);

        //assertNull(order);
    }

    @Test
    public void testGetAllOrders() throws SQLException {
        Set<Order> orders = orderDao.getAllOrders();
        System.out.println(orders);
        System.out.println(orders.size());
        assertTrue(orders.size() > 15);
    }

    @Test
    public void testGetAllOrdersJoin() throws SQLException {
        Set<Order> orders = orderDao.getAllOrdersInnerJoin();
        System.out.println(orders);
        System.out.println(orders.size());
        assertEquals(orderDao.getAllOrders().size(), orders.size());
    }

    @Test
    public void testInsertOrder() throws SQLException {
        assertTrue(orderDao.insertOrder(order));
    }

    @Test
    public void testUpdateOrder() throws SQLException {
        assertTrue(orderDao.updateOrder(order));
    }

    @Test
    public void testDeleteOrder() throws SQLException {
        assertTrue(orderDao.deleteOrder(new BigDecimal(1234)));

    }

}
