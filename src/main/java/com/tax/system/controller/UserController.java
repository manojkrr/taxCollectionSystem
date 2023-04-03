package com.tax.system.controller;

import com.tax.system.entities.User;
import com.tax.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user.getUsername(), user.getPassword());
        model.addAttribute("message", "User registered successfully!");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User loggedUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedUser != null) {
            model.addAttribute("message", "Logged in successfully!");
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("message", "Welcome to the dashboard!");
        return "index";
    }
}
