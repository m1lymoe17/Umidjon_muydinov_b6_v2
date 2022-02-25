package com.app.controller;

import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    private UserRepository userRepository;

    @GetMapping()
    public String getLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        for (User user : userRepository.getUserList()) {
            if (session.getAttribute("user").equals(user.getId())) {
                model.addAttribute("user", user);
                return "home";
            }
        }
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
