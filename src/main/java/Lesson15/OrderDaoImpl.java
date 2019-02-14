package Lesson15;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {


    @Override
    public Set<Order> getAllOrders() throws SQLException {
        Connection connection = ConnectToDB.getConnection();
        Set<Order> orders = new HashSet<>();

        String sql = "select * from orders";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {

            Order order = new Order(resultSet.getBigDecimal("order_Num"), null, resultSet.getDate("order_Date").toLocalDate(), resultSet.getString("mfr"),
                    resultSet.getBigDecimal("qty"), resultSet.getBigDecimal("amount"));

            stmt = connection.prepareStatement("select * from  products where product_id=?");
            stmt.setString(1, resultSet.getString("PRODUCT"));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getString("product_Id"), rs.getString("mfr_Id"),
                        rs.getString("description"), rs.getBigDecimal("price"), rs.getBigDecimal("qty_On_Hand"));
                order.setProduct(product);
            }
            rs.close();
            orders.add(order);
        }
        resultSet.close();
        stmt.close();
        connection.close();
        return orders;
    }

    @Override
    public Set<Order> getAllOrdersInnerJoin() throws SQLException {
        Set<Order> orders = new HashSet<>();
        Connection connection = ConnectToDB.getConnection();
        String sql = "SELECT * FROM orders o INNER JOIN products p ON o.product = p.product_id";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Product product = new Product(rs.getString("product_Id"), rs.getString("mfr_Id"),
                    rs.getString("description"), rs.getBigDecimal("price"), rs.getBigDecimal("qty_On_Hand"));

            Order order = new Order(rs.getBigDecimal("order_Num"), product, rs.getDate("order_Date").toLocalDate(), rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));

            orders.add(order);

        }

        return orders;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {
        Connection connection = ConnectToDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select * from orders where order_num=?");
        stmt.setBigDecimal(1, id);
        ResultSet rs = stmt.executeQuery();

        Order order = null;
        if (rs.next()) {
            order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date").toLocalDate(), rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));
        }
        rs.close();
        stmt.close();
        connection.close();
        return order;

    }

    @Override
    public boolean insertOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        return false;
    }
}
