package Lesson15;

import java.math.BigDecimal;
import java.sql.*;
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
        Connection connection = ConnectToDB.getConnection();
        String sql = "insert into orders(order_num, order_date) VALUES (?,?)";
        PreparedStatement state = connection.prepareStatement(sql);
        state.setBigDecimal(1, order.getOrderNum());
        state.setDate(2, Date.valueOf(order.getOrderDate()));

        boolean update = state.executeUpdate() > 0;

        state.close();
        connection.close();
        return update;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        Connection connection = ConnectToDB.getConnection();
        String sql = "UPDATE orders SET qty=?, mfr=?  WHERE order_num=?";
        PreparedStatement state = connection.prepareStatement(sql);
        state.setBigDecimal(1, order.getQty());
        state.setString(2, order.getMfr());
        state.setBigDecimal(3, order.getOrderNum());

        boolean update = state.executeUpdate() > 0;

        state.close();
        connection.close();
        return update;

    }

    @Override
    public boolean deleteOrder(Order order) throws SQLException {

        return (new CRUDTemplate() {

            @Override
            public PreparedStatement returnPreparedStatement(Order order, Connection connection) throws SQLException {
                PreparedStatement statement;
                String sql = "delete orders where order_num=?";
                statement = connection.prepareStatement(sql);
                statement.setBigDecimal(1, order.getOrderNum());
                return statement;
            }
        }).templateOperation(order);
    }


    private abstract class CRUDTemplate {
        public boolean templateOperation(Order order) throws SQLException {
            boolean update = false;
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = ConnectToDB.getConnection();
                statement = returnPreparedStatement(order, connection);
                update = statement.executeUpdate() > 0;

            } finally {
                statement.close();
                connection.close();
            }
            return update;
        }

        public abstract PreparedStatement returnPreparedStatement(Order order, Connection connection) throws SQLException;

    }

    private void showMetadata(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; ++i) {
            System.out.println(resultSetMetaData.getColumnCount());
            System.out.println(resultSetMetaData.getColumnName(1));
            System.out.println(resultSetMetaData.getSchemaName(2));
        }
    }


}
