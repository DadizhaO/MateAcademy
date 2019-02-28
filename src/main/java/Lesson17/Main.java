package Lesson17;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static EntityManager manager = factory.createEntityManager();


    public static void main(String[] args) {

        String sql = "select o from Office o";
        List list = manager.createQuery(sql).getResultList();
        System.out.println(list);
        System.out.println("----");

        Query query = manager.createQuery("SELECT s FROM Salesrep s join s.repOffice o WHERE o.officeId=:officeId");
        query.setParameter("officeId", 13);
        List result = query.getResultList();
        System.out.println(result);
        System.out.println("----");

        Query query2 = manager.createQuery("SELECT ord FROM Order ord join ord.cust c WHERE c.custNum=:custNum");
        query2.setParameter("custNum", 2111);
        List result2 = query2.getResultList();
        System.out.println(result2);
        System.out.println("----");

        Query query3 = manager.createQuery("SELECT ord FROM Order ord join ord.rep s WHERE s.emplNum=:emplNum");
        query3.setParameter("emplNum", 106);
        List result3 = query3.getResultList();
        System.out.println(result3);
        System.out.println("----");

        Query query4 = manager.createQuery("SELECT c FROM Customer c join c.custRep s WHERE s.emplNum=:emplNum");
        query4.setParameter("emplNum", 106);
        List result4 = query4.getResultList();
        System.out.println(result4);
        System.out.println("----");

    }

}
