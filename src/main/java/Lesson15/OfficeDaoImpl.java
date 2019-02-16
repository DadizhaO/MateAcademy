package Lesson15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OfficeDaoImpl implements OfficeDao {


    @Override
    public Set<Office> getAllOffices() throws SQLException {
        Set<Office> offices = new HashSet<>();
        Connection connection = ConnectToDB.getConnection();
        String sql = "select * from offices";
        PreparedStatement stmt = connection.prepareStatement(sql);
        return getOffices(offices, connection, stmt);
    }

    @Override
    public Set<Office> getByRegion(String region) throws SQLException {
        Set<Office> offices = new HashSet<>();
        Connection connection = ConnectToDB.getConnection();
        String sql = "SELECT * FROM offices WHERE region = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, region);
        return getOffices(offices, connection, prepareStatement);

    }

    private Set<Office> getOffices(Set<Office> offices, Connection connection, PreparedStatement prepareStatement) throws SQLException {
        ResultSet resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            Office office = new Office(resultSet.getBigDecimal("office"), resultSet.getString("city"), resultSet.getString("region"),
                    resultSet.getBigDecimal("mgr"), resultSet.getBigDecimal("target"), resultSet.getBigDecimal("sales"));
            offices.add(office);
        }
        resultSet.close();
        prepareStatement.close();
        connection.close();
        return offices;
    }
}
