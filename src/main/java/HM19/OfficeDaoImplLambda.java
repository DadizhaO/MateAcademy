package HM19;

import Lesson15.ConnectToDB;
import Lesson15.Office;
import Lesson15.OfficeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public class OfficeDaoImplLambda implements OfficeDao {


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

    @Override
    public boolean insertOffice(Office office) throws SQLException {
        return
                ((TemplateInterface) connection -> {
                    PreparedStatement state;
                    String sql = "insert into offices(office,city,region,sales) values (?,?,?,?)";
                    state = connection.prepareStatement(sql);
                    state.setBigDecimal(1, office.getOfficeId());
                    state.setString(2, office.getCity());
                    state.setString(3, office.getRegion());
                    state.setBigDecimal(4, office.getSales());
                    return state;
                }).operationTemplate();
    }


    @Override
    public boolean updateOffice(Office office) throws SQLException {
        return
                ((TemplateInterface) (connection) -> {
                    PreparedStatement state;
                    String sql = "UPDATE offices SET city=?,region=?, target=?, sales=?  WHERE office=?";
                    state = connection.prepareStatement(sql);
                    state.setString(1, office.getCity());
                    state.setString(2, office.getRegion());
                    state.setBigDecimal(3, office.getTarget());
                    state.setBigDecimal(4, office.getSales());
                    state.setBigDecimal(5, office.getOfficeId());
                    return state;
                }).operationTemplate();

    }

    @Override
    public boolean deleteOffice(Office office) throws SQLException {
        return
                ((TemplateInterface) (connection) -> {
                    PreparedStatement state;
                    String sql = "delete offices where office=?";
                    state = connection.prepareStatement(sql);
                    state.setBigDecimal(1, office.getOfficeId());
                    return state;
                }).operationTemplate();
    }

}
