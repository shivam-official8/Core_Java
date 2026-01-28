package com.shivam.jsp_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddController {

    @GetMapping("/")
    public  String addJsp(@PathVariable int num1, @PathVariable int num2,  Model model){
        model.addAttribute("k", num1+num2);
        return "add";
    }
}
