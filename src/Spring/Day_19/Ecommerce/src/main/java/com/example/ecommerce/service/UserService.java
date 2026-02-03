package com.example.ecommerce.service;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Product> allProducts(){
        return productRepo.findAll();
    }

    public ResponseEntity<String> updateUserDetails(Users users){
        userRepo.save(users);
        return new ResponseEntity<>("Details updated.", HttpStatus.OK);
    }





    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<String> register(Users users){
        if(userRepo.findByUsername(users.getUsername())!=null)return new ResponseEntity<>("User Already Exists!", HttpStatus.ALREADY_REPORTED);
        users.setPassword(encoder.encode(users.getPassword()));
        userRepo.save(users);
        return new ResponseEntity<>("User Register", HttpStatus.CREATED);
    }

    public String verify(Users users) {
        Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername()
                ,users.getPassword()));

        if(auth.isAuthenticated())    return jwtService.generateToken(users.getUsername());
        return "fail";

    }

}
