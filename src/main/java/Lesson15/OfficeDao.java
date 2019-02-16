package Lesson15;

import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {


    Set<Office> getAllOffices() throws SQLException;

    Set<Office> getByRegion(String region) throws SQLException;
}
