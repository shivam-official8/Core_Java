package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Users;
import com.example.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAllProducts")
    public List<Product> allProducts(){
        return adminService.allProducts();
    }
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
       return adminService.addProduct(product);
    }

    @PostMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        return adminService.updateProduct(product);
    }
    @PostMapping("/deleteProduct/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable long pid){
        return adminService.deleteProduct(pid);
    }

    @PostMapping("/addAdmin/{uid}")
    public ResponseEntity<String> addAdmin(@PathVariable long uid){
        return adminService.addAdmin(uid);
    }

    @GetMapping("/getAllUsers")
    public List<Users> allUsers(){
        return adminService.allUsers();
    }

}
