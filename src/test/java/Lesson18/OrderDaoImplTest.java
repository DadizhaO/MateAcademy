package Lesson18;

import Lesson17.Order;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderDaoImplTest {
    private OrderDaoImpl orderDao = new OrderDaoImpl();

    @Test
    public void getAllOrders() {
    }

    @Test
    public void findOrderById() {
        Order order = orderDao.findOrderById(new BigDecimal(113036));
        System.out.println(order);
    }

    @Test
    public void insertOrder() {
    }

    @Test
    public void updateOrder() {
    }

    @Test
    public void deleteOrder() {
    }
}