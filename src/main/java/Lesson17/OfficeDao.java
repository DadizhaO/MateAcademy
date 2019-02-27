package Lesson17;

import java.util.Set;

public interface OfficeDao {

    Set<Office> getAllOffices();

    Set<Office> getByRegion(String region);

    boolean insertOffice(Office office);

    boolean updateOffice(Office office);

    boolean deleteOffice(Office office);
}
