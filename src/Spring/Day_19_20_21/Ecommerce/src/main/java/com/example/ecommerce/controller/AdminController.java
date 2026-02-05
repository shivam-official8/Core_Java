package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Users;
import com.example.ecommerce.service.AdminService;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        assert auth != null;
        System.out.println(auth.getAuthorities());
       return adminService.addProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        return adminService.updateProduct(product);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/deleteProduct/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable long pid){
        return adminService.deleteProduct(pid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addAdmin/{uid}")
    public ResponseEntity<String> addAdmin(@PathVariable long uid){
        return adminService.addAdmin(uid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllUsers")
    public List<Users> allUsers(){
        return adminService.allUsers();
    }

}
