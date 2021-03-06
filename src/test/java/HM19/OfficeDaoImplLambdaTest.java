package HM19;

import Lesson15.Office;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeDaoImplLambdaTest {

    private OfficeDaoImplLambda officeDaoImplLambda = new OfficeDaoImplLambda();

    private Office office1 = new Office(new BigDecimal(120), "city", "region",
            null, null, new BigDecimal(1223));
    private Office office2 = new Office(new BigDecimal(120), "city2", "region2",
            null, new BigDecimal(10101), new BigDecimal(20202));


    @Test
    public void test1InsertOffice() throws SQLException {

        assertTrue(officeDaoImplLambda.insertOffice(office1));
    }

    @Test
    public void test2UpdateOffice() throws SQLException {

        assertTrue(officeDaoImplLambda.updateOffice(office2));
    }

    @Test
    public void test3DeleteOffice() throws SQLException {
        assertTrue(officeDaoImplLambda.deleteOffice(office2));
        Set<Office> offices = officeDaoImplLambda.getAllOffices();
        assertFalse(offices.contains(office1));
        assertFalse(offices.contains(office2));
    }
}