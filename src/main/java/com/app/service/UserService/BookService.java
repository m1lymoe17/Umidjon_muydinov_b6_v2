package com.app.service.UserService;

import com.app.model.Book;
import com.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookList(int id) {
        return bookRepository.getUserBooks(id);
    }

    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    public String getDeleteBook(int id) {
        boolean b = bookRepository.deleteBook(id);
        if (b) {
            return "Successfully deleted!";
        }
        return "Could not delete!";
    }

    public String getSave(Book book) {
        if (book.getId() != null) {
            boolean b = bookRepository.editBook(book);
            if (b) {
                return "Successfully edited!";
            }
            return "Could not edit!";
        }
        boolean b = bookRepository.saveBook(book);
        if (b) {
            return "Successfully saved!";
        } else {
            return "Could not save!";
        }
    }
}
