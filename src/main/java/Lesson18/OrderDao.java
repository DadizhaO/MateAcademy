package Lesson18;


import Lesson17.Order;

import java.math.BigDecimal;
import java.util.Set;

public interface OrderDao {
    Set<Order> getAllOrders();

    Order findOrderById(BigDecimal id);

    boolean insertOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(Order order);
}
