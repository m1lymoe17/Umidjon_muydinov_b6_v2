package com.app.repository;

import com.app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getUserBooks(int id) {
        String query = "select * from books where user_id=" + id;
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setName(rs.getString(3));
            book.setUserId(rs.getInt(4));
            return book;
        });
    }

    public List<Book> getBooks() {
        String query = "select * from books";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setName(rs.getString(3));
            book.setUserId(rs.getInt(4));
            return book;
        });
    }

    public Book getBookById(int id) {
        String query = "select * from books where id = " + id;
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setName(rs.getString(3));
            book.setUserId(rs.getInt(4));
            return book;
        });
    }

    public boolean saveBook(Book book) {
        String query =
                "insert into books(title, name,user_id) " +
                "values ('" + book.getTitle() + "','" + book.getName() + "'," + book.getUserId() + ")";
        return jdbcTemplate.update(query) > 0;
    }

    public boolean deleteBook(int id) {
        String query = "delete from books where id = " + id;
        return jdbcTemplate.update(query) > 0;
    }

    public boolean editBook(Book book) {
        String query =
                "update books set title = '" + book.getTitle() + "', name='" + book.getName() + "' where id=" + book.getId();
        return jdbcTemplate.update(query) > 0;
    }

}
