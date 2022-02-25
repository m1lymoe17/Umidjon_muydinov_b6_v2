package com.app.controller;


import com.app.model.Book;
import com.app.service.UserService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("{id}")
    public String getBooks(int id) {

        return "login-register";
    }

    @RequestMapping("/save")
    public String save(Book book, Model model) {
        String save = bookService.getSave(book);
        model.addAttribute("save", save);
        return "home";
    }
}
