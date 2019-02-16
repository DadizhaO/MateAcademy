package Lesson15;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeDaoImplIntegrationTest {

    private OfficeDao officeDao = new OfficeDaoImpl();
    private Office office1 = new Office(new BigDecimal(120), "city", "region",
            null, null, new BigDecimal(1223));
    private Office office2 = new Office(new BigDecimal(120), "city2", "region2",
            null, new BigDecimal(10101), new BigDecimal(20202));


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

    @Test
    public void test1InsertOffice() throws SQLException {
        assertTrue(officeDao.insertOffice(office1));
    }

    @Test
    public void test2UpdateOffice() throws SQLException {
        assertTrue(officeDao.updateOffice(office2));

    }

    @Test
    public void test3DeleteOffice() throws SQLException {
        assertTrue(officeDao.deleteOffice(office2.getOfficeId()));
        Set<Office> offices = officeDao.getAllOffices();
        assertFalse(offices.contains(office1));
        assertFalse(offices.contains(office2));
    }
}
