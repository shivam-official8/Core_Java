package com.example.jsp_ecommerce.controller.pagecontroller;

import com.example.jsp_ecommerce.entity.Product;
import com.example.jsp_ecommerce.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER')")
    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {

        model.addAttribute("products", userService.allProducts());
        model.addAttribute("roles", authentication.getAuthorities());

        return "home";
    }
}

