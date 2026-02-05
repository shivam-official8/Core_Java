package com.example.ecommerce.service;

import com.example.ecommerce.dto.UpdateUserRequest;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Users;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Product> allProducts(){
        return productRepo.findAll();
    }

    public void updateUserDetails(String username, UpdateUserRequest request) {
        Users user = userRepo.findByUsername(username);
        if(user==null){new RuntimeException("User not found"); return;}

        user.setName(request.getName());

        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        userRepo.save(user);
    }


    public Users findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
