package com.example.session_auth.controller;

import com.example.session_auth.entity.Users;
import com.example.session_auth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/login")
    public String loginPage() {
        System.out.println("login");
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        System.out.println("signup");
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password) {
        System.out.println("signup post");

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        repo.save(user);

        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("home");
        return "home";
    }
}