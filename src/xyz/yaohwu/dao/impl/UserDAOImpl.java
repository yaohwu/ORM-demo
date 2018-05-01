package xyz.yaohwu.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import xyz.yaohwu.dao.UserDAO;
import xyz.yaohwu.entity.User;
import xyz.yaohwu.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {


    @Override
    public void save(User user) {
        try (Session session = getSession()) {
            Transaction ts = session.beginTransaction();
            session.save(user);
            ts.commit();
        }
    }


    @Override
    public User findUserById(int id) {
        try (Session session = getSession()) {
            return session.get(User.class, id);
        }
    }

    private Session getSession() {
        return HibernateUtil.getSession();
    }

}
