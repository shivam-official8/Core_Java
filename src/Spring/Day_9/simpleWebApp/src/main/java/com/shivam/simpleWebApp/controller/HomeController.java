package com.shivam.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String Greet(){
        return "Welcome To Mars...";
    }

    @RequestMapping("/about")
    public String about(){
        return "I love video games 🤩";
    }
}
