package com.app.controller;


import com.app.model.Book;
import com.app.model.User;
import com.app.repository.BookRepository;
import com.app.repository.UserRepository;
import com.app.service.UserService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @GetMapping()
    public String getLogin() {
        return "login-register";
    }

    @PostMapping("login")
    public String getLoginPost(User user, HttpServletRequest req, Model model) {
        User loggedUser = userRepository.getLoggedUser(user);
        if (loggedUser != null) {
            HttpSession session = req.getSession();
            session.setAttribute("name", loggedUser.getId());
            session.setMaxInactiveInterval(3600);
            model.addAttribute("user", loggedUser);
            List<Book> bookList = bookService.getBookList(loggedUser.getId());
            model.addAttribute("bookList", bookList);
            return "home";
        }
        model.addAttribute("Something wrong");
        return "login-register";
    }

    @PostMapping("register")
    public String getRegister(User user, Model model) {
        boolean b = userRepository.saveUser(user);
        if (b) {
            model.addAttribute("msg", "Successfully registered!");
            return "login-register";
        }
        model.addAttribute("msg", "Could not registered!");
        return "login-register";
    }
}
