package com.example.jsp_ecommerce.controller.restcontroller;

import com.example.jsp_ecommerce.dto.UpdateUserRequest;
import com.example.jsp_ecommerce.entity.Product;
import com.example.jsp_ecommerce.entity.Users;
import com.example.jsp_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER')")
    @GetMapping("/getAllProducts")
    public List<Product> allProducts(){
        return userService.allProducts();
    }

    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER')")
    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUserDetails(
            @RequestBody UpdateUserRequest request
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assert auth != null;
        String username = auth.getName();

        userService.updateUserDetails(username, request);
        return ResponseEntity.ok("Details updated");
    }





}
