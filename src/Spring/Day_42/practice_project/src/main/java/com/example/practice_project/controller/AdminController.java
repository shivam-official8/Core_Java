package com.example.practice_project.controller;

import com.example.practice_project.dto.CategoryAddRequest;
import com.example.practice_project.dto.ProductSaveRequest;
import com.example.practice_project.dto.RegisterRequest;
import com.example.practice_project.entity.Category;
import com.example.practice_project.entity.Product;
import com.example.practice_project.entity.Users;
import com.example.practice_project.enums.Role;
import com.example.practice_project.repository.UserRepo;
import com.example.practice_project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

  @Autowired
  private AdminService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody RegisterRequest request){
        return service.createAdmin(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductSaveRequest product){
        return service.addProduct(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit-product/{id}")
    public ResponseEntity<String> editProduct(@PathVariable Long id, @RequestBody ProductSaveRequest product){
        return service.editProduct(id, product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return service.deleteProduct(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-products")
    public ResponseEntity<List<Product>> allProducts(){
        return service.allProducts();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-category")
    public ResponseEntity<String> addCategory(@RequestBody CategoryAddRequest request){
        return service.addCategory(request);
    }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/product/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id){
    return service.getProductById(id);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/all-categories")
  public ResponseEntity<List<Category>> allCategories(){
      return service.getAllCategories();
  }
}
