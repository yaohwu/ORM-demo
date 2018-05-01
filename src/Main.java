import xyz.yaohwu.dao.BookDAO;
import xyz.yaohwu.dao.UserDAO;
import xyz.yaohwu.dao.impl.BookDAOImpl;
import xyz.yaohwu.dao.impl.UserDAOImpl;
import xyz.yaohwu.entity.Book;
import xyz.yaohwu.entity.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // user
        User user = new User();
        user.setUsername("yaohwu");
        user.setPassword("password");
        UserDAO userDao = new UserDAOImpl();
        userDao.save(user);
        user = userDao.findUserById(1);
        if (user != null) {
            System.out.println("所查询ID的姓名是: " + user.getUsername());
        }


        // book
        Book book = new Book();
        book.setAuthor("yaohwu");
        BookDAO bookDAO = new BookDAOImpl();

        bookDAO.save(book);
        book = bookDAO.findBookById(1);
        if (book != null) {
            System.out.println("所查询ID的书籍作者是: " + book.getAuthor());
        }

        BookDAO bookDAOSearch = new BookDAOImpl();
        List<Book> books = bookDAOSearch.findBooksWrittenByAuthor("yaohwu");

        if (books != null) {
            for (Book b : books) {
                System.out.println("所查作者的著作id是: " + b.getId());
            }
        }


        System.exit(0);
    }
}
