package com.shivam.jsp_login_signup.controller;

import com.shivam.jsp_login_signup.entity.User;
import com.shivam.jsp_login_signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.login(email, password);
        if(user!=null){
            model.addAttribute("username", user.getUsername());
            return "home";
        }
        model.addAttribute("error", "Invalid Credentials!");
        return "login";
    }
}