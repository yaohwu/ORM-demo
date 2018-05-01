package xyz.yaohwu.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import xyz.yaohwu.entity.Book;

import javax.persistence.EntityManager;

public final class HibernateUtil {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addResource("/xyz/yaohwu/entity/User.hbm.xml");
            configuration.addAnnotatedClass(Book.class);
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

//    public static EntityManager createEntityManager(){
//
//
//    }


}