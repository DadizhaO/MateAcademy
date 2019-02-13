package Lesson15;


import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

public class OrderDaoImplIntegrationTest {


    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testFindOrderByIdNotPresent() throws SQLException {
        Order order = orderDao.findOrderById(new BigDecimal(112922));
        System.out.println(order);

        //assertNull(order);
    }
}
