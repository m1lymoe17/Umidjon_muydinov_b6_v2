package com.app.controller;


import com.app.model.Book;
import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService.BookService;
import com.app.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/get-save/{userId}")
    public String getSaveForm(@PathVariable(required = false, name = "userId") Integer userId, Model model) {
        model.addAttribute("userId", userId);
        return "save-book";
    }

    @RequestMapping("/get-edit/{id}")
    public String getEditForm(@PathVariable(name = "id") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @RequestMapping("/save")
    public String save(Book book, Model model) {
        int userId = book.getUserId();
        List<Book> bookList = bookService.getBookList(userId);
        model.addAttribute("bookList", bookList);
        String save = bookService.getSave(book);
        model.addAttribute("save", save);
        return "home";
    }

    @RequestMapping("/delete/{id}")
    public String getDelete(@PathVariable int id, Model model) {
        Book bookById = bookService.getBookById(id);
        int userId = bookById.getUserId();
        User userById = userRepository.getUserById(userId);
        List<Book> bookList = bookService.getBookList(userId);
        model.addAttribute("bookList", bookList);
        bookService.getDeleteBook(id);
        model.addAttribute("user", userById);
        return "home";
    }
}
