package HM19;

import Lesson15.ConnectToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TemplateAbs<T> {
    boolean operationTemplate(T t) throws SQLException {
        Connection connection = null;
        PreparedStatement state = null;
        boolean update = false;
        try {
            connection = ConnectToDB.getConnection();
            state = returnPreparedStatement(t, connection);

            update = state.executeUpdate() > 0;
        } finally {
            state.close();
            connection.close();
        }

        return update;
    }

    public abstract PreparedStatement returnPreparedStatement(T t, Connection connection) throws SQLException;
}