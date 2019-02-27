package Lesson17;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.JVM)
public class OrderDaoImplIntegrationTest {


    private OrderDao orderDao = new OrderDaoImpl();
    Order order = new Order(
            new BigDecimal(1234), null, LocalDate.of(1990, 12, 13), "mfr", null, new BigDecimal(123.12));


    @Test
    public void testInsertOrder() {
        assertTrue(orderDao.insertOrder(order));
    }

    @Test
    public void testUpdateOrder() {
        assertTrue(orderDao.updateOrder(order));
    }

    @Test
    public void testDeleteOrder() {
        assertTrue(orderDao.deleteOrder(new Order(new BigDecimal(1234))));

    }

    @Test
    public void testFindOrderById() {
        Order order = orderDao.findOrderById(new BigDecimal(112922));
        System.out.println(order);
    }

}
