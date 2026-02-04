package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Users;
import com.example.ecommerce.service.AuthService;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users){
        return authService.register(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        System.out.println(users);
        return authService.verify(users);
    }
}
