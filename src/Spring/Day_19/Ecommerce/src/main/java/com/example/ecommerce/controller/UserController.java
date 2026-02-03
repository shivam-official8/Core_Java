package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Users;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/updateUser")
    public ResponseEntity<String> updateUserDetails(@RequestBody Users users){
        userService.updateUserDetails(users);
        return new ResponseEntity<>("Details updated.", HttpStatus.OK);
    }



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users){
        return userService.register(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        System.out.println(users);
        return userService.verify(users);
    }
}
