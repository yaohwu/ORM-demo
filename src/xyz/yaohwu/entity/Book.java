package xyz.yaohwu.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * @author yaohwu
 */
@Entity
@Table(name = "book", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id",
                "author"
        })
})
public class Book {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "author", nullable = false)
    private String author;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
