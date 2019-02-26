package Lesson17;

import javax.persistence.EntityManager;
import java.util.Set;

public class OfficeDaoImpl implements OfficeDao {

    private EntityManager manager;

    public OfficeDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Set<Office> getAllOffices() {
        return null;
    }

    @Override
    public Set<Office> getByRegion(String region) {
        return null;
    }

    @Override
    public boolean insertOffice(Office office) {

        return ((OfficeTemplate) (manager) -> manager.persist(office)).operationTemplate(manager);
    }

    @Override
    public boolean updateOffice(Office office) {

        return ((OfficeTemplate) manager -> manager.merge(office)).operationTemplate(manager);
    }

    @Override
    public boolean deleteOffice(Office office) {

        return ((OfficeTemplate) (manager) -> manager.remove(
                manager.getReference(Office.class, office.getOfficeId())))
                .operationTemplate(manager);
    }
}
