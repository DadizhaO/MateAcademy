package HM19;

import Lesson15.ConnectToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface TemplateInterface {
    default boolean operationTemplate() throws SQLException {
        Connection connection = null;
        PreparedStatement state = null;
        boolean update = false;
        try {
            connection = ConnectToDB.getConnection();
            state = returnPrepareStatement(connection);
            update = state.executeUpdate() > 0;
        } finally {
            state.close();
            connection.close();
        }
        return update;

    }

    PreparedStatement returnPrepareStatement(Connection connection) throws SQLException;

}
