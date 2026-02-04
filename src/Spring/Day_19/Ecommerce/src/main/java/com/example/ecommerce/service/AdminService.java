package com.example.ecommerce.service;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Users;
import com.example.ecommerce.enums.Role;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;


//    public List<Product> allProducts(){
//        return productRepo.findAll();
//    }

    public ResponseEntity<String> addProduct(Product product){
        productRepo.save(product);
        return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateProduct(Product product){
        productRepo.save(product);
        return new ResponseEntity<>("Product updated successfully.", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteProduct(long id){
        productRepo.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
    }



    public ResponseEntity<String> addAdmin(long uid){
        Users users = userRepo.findById(uid).get();
        users.setRole(Role.ADMIN);
        return new ResponseEntity<>("Admin added.", HttpStatus.OK);
    }

    public List<Users> allUsers(){
        return userRepo.findAll();
    }

    public ResponseEntity<String> deleteUser(long id){
        userRepo.deleteById(id);
        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
    }
}
