package com.app.controller;


import com.app.model.Book;
import com.app.service.UserService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("{id}")
    public String getBooks(int id) {

        return "login-register";
    }

    @RequestMapping("/get-form")
    public String getForm(@RequestParam(required = false, name = "id") Integer id, @RequestParam(required = false, name =
            "userId") Integer userId, Model model) {
        if (userId != null) {
            model.addAttribute("userId", userId);
        }
        if (id != null) {
            Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
        }
        return "book-form";
    }

    @RequestMapping("/save")
    public String save(Book book, Model model) {
        String save = bookService.getSave(book);
        model.addAttribute("save", save);
        return "home";
    }

    @RequestMapping("/delete/{id}")
    public String getDelete(int id, Model model) {

        String deleteBook = bookService.getDeleteBook(id);
        model.addAttribute("msg", deleteBook);
        return "home";
    }
}
