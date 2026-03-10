package com.example.practice_project.service;

import com.example.practice_project.dto.CategoryAddRequest;
import com.example.practice_project.dto.ProductSaveRequest;
import com.example.practice_project.dto.RegisterRequest;
import com.example.practice_project.entity.Category;
import com.example.practice_project.entity.Product;
import com.example.practice_project.entity.Users;
import com.example.practice_project.enums.Role;
import com.example.practice_project.repository.CategoryRepo;
import com.example.practice_project.repository.ProductRepo;
import com.example.practice_project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;



    public ResponseEntity<String> createAdmin(RegisterRequest request){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;
        String username = authentication.getName();
        System.out.println("Username: "+username);
        if(!username.equals("admin@gmail.com")){
            return new ResponseEntity<>("You don't have authority to add new admin only main admin can add delete other admins.", HttpStatus.FORBIDDEN);
        }
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.ADMIN);
        userRepo.save(user);
        return new ResponseEntity<>("Admin created successfully.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addProduct(ProductSaveRequest product){
        Product product1 = new Product();
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setCategory(product.getCategory());
        product1.setName(product.getName());
        product1.setStock(product.getStock());
        productRepo.save(product1);
        return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> editProduct(Long id, ProductSaveRequest product){
        Product product1 = productRepo.findById(id).get();
        product1.setCategory(product.getCategory());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setStock(product.getStock());
        product1.setPrice(product.getPrice());
        productRepo.save(product1);
        return new ResponseEntity<>("Product edited.", HttpStatus.OK);
    }
    public ResponseEntity<String> deleteProduct(Long prodId){
        productRepo.deleteById(prodId);
        return new ResponseEntity<>("Product deleted.", HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> allProducts(){
       return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addCategory(CategoryAddRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        categoryRepo.save(category);
        return new ResponseEntity<>("Category added.", HttpStatus.CREATED);
    }

    public ResponseEntity<Product> getProductById(Long id){
      return new ResponseEntity<>(productRepo.getReferenceById(id), HttpStatus.OK);
    }

    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryRepo.findAll(), HttpStatus.OK);
    }
}
