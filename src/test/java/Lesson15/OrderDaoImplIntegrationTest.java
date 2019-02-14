package Lesson15;


import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderDaoImplIntegrationTest {


    private OrderDao orderDao = new OrderDaoImpl();

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

}
