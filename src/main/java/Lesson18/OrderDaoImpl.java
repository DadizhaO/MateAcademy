package Lesson18;


import Lesson17.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.math.BigDecimal;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);

    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {


        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Order.class);
        configObj.addAnnotatedClass(Customer.class);
        configObj.addAnnotatedClass(Office.class);
        configObj.addAnnotatedClass(Product.class);
        configObj.addAnnotatedClass(Salesrep.class);
        configObj.configure(new File("src//main//resources//hibernate//hibernate.cfg.xml"));

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    @Override
    public Set<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) {
        Order order = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            order = sessionObj.load(Order.class, id);
        } catch (Exception sqlException) {

            if (null != sessionObj.getTransaction()) {
                sqlException.printStackTrace();
            }
            sqlException.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean insertOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return false;
    }
}
