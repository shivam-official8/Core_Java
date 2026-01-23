package com.shivam.ecommerce.controller;

import com.shivam.ecommerce.entity.UserProfile;
import com.shivam.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;
    @PostMapping("/adduser")
    public void addUser(@RequestBody UserProfile userProfile){
        service.addUser(userProfile);
    }

    @GetMapping("/alluser")
    public List<UserProfile> getUsers(){
        return service.getUsers();
    }
}
