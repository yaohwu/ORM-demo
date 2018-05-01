package xyz.yaohwu.dao;

import xyz.yaohwu.entity.Book;

import java.util.List;

public interface BookDAO {

    void save(Book book);

    Book findBookById(int id);

    List<Book> findBooksWrittenByAuthor(String author);

//    List<Book> findBooksWrittenByAuthorNew(String author);
}
