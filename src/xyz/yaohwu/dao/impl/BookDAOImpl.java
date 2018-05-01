package xyz.yaohwu.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import xyz.yaohwu.dao.BookDAO;
import xyz.yaohwu.entity.Book;
import xyz.yaohwu.util.HibernateUtil;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public void save(Book book) {

        try (Session session = getSession()) {
            Transaction ts = session.beginTransaction();
            session.save(book);
            ts.commit();
        }
    }

    @Override
    public Book findBookById(int id) {
        try (Session session = getSession()) {
            return session.get(Book.class, id);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findBooksWrittenByAuthor(String author) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("author", author));
        criteria.setMaxResults(10);
        return criteria.list();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Book> findBooksWrittenByAuthorNew(String author) {
//
//        criteria.add(Restrictions.eq("author", author));
//        criteria.setMaxResults(10);
//        return criteria.list();
//    }

    private Session getSession() {
        return HibernateUtil.getSession();
    }

}
