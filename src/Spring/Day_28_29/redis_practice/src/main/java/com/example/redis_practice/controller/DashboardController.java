package com.example.redis_practice.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        String role = (String) session.getAttribute("role");

        if (userId == null) {
            return "Not logged in";
        }

        return "Welcome user " + userId + " with role " + role;
    }
}

