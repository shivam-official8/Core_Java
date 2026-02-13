package com.example.security_practice.controller;

import com.example.security_practice.dto.AuthRequest;
import com.example.security_practice.dto.RegisterRequest;
import com.example.security_practice.model.Users;
import com.example.security_practice.repository.UserRepo;
import com.example.security_practice.service.MyUserDetailsService;
import com.example.security_practice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        System.out.println("inside register api");

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepo.save(user);

        return "User registered successfully";
    }



    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        System.out.println("inside login api");
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(),
                                    request.getPassword()
                            )
                    );

            System.out.println("AUTH SUCCESS");

            return jwtUtil.generateToken(
                    (UserDetails) authentication.getPrincipal()
            );

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
