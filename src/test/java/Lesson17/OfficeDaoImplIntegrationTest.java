package Lesson17;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeDaoImplIntegrationTest {


    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    private EntityManager manager = factory.createEntityManager();
    private OfficeDao officeDao = new OfficeDaoImpl(manager);


    private Office office1 = new Office(new BigDecimal(120), "city", "region",
            null, null, new BigDecimal(1223));
    private Office office2 = new Office(new BigDecimal(120), "city2", "region2",
            null, new BigDecimal(10101), new BigDecimal(20202));


    @Test
    public void test1InsertOffice() {
        assertTrue(officeDao.insertOffice(office1));
        List<Office> offices = manager.createQuery("SELECT o FROM Office o", Office.class).getResultList();
        System.out.println(offices);
        assertTrue(offices.contains(office1));
        assertEquals(6, offices.size());
    }

    @Test
    public void test2UpdateOffice() {
        assertTrue(officeDao.updateOffice(office2));
    }

    @Test

    public void test3DeleteOffice() {
        assertTrue(officeDao.deleteOffice(office1));
        List<Office> offices = manager.createQuery("select o from Office o", Office.class).getResultList();
        System.out.println(offices);
        assertEquals(5, offices.size());
        assertFalse(offices.contains(office1));
    }
}
