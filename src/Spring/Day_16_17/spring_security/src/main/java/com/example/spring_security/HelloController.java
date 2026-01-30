package com.example.spring_security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
public String greet(HttpServletRequest req){
    return "welcome to mars..."+req.getSession().getId();
}




}
