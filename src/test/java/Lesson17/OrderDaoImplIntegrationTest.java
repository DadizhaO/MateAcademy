package Lesson17;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class OrderDaoImplIntegrationTest {


    private OrderDao orderDao = new OrderDaoImpl();
    Order order = new Order(
            new BigDecimal(1234), null, LocalDate.of(1990, 12, 13), "mfr", null, new BigDecimal(123.12));


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
        assertTrue(orderDao.deleteOrder(order));

    }

}
