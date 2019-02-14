package Lesson15;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class OfficeDaoImplIntegrationTest {

    private OfficeDao officeDao = new OfficeDaoImpl();
    @Test
    public void testGetAllOffices() throws SQLException {
        Set<Office> offices = officeDao.getAllOffices();
        System.out.println(offices);
        assertEquals(offices.size(), 5);
    }

    @Test
    public void testGetByRegion() throws SQLException {
        Set<Office> offices = officeDao.getByRegion("Восток");
        System.out.println(offices);
        System.out.println(offices.size());
        assertEquals(offices.size(), 3);
    }
}
