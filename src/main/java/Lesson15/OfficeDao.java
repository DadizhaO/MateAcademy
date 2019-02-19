package Lesson15;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OfficeDao {


    Set<Office> getAllOffices() throws SQLException;

    Set<Office> getByRegion(String region) throws SQLException;

    boolean insertOffice(Office office) throws SQLException;

    boolean updateOffice(Office office) throws SQLException;

    boolean deleteOffice(Office office) throws SQLException;
}