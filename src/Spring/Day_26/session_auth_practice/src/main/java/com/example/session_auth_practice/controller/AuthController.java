package com.example.session_auth_practice.controller;

import com.example.session_auth_practice.dto.AuthRequest;
import com.example.session_auth_practice.dto.RegisterRequest;
import com.example.session_auth_practice.entity.Userss;
import com.example.session_auth_practice.repository.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        System.out.println("inside register api");

        Userss user = new Userss();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepo.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody AuthRequest request,
            HttpServletRequest httpRequest
    ) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);

        httpRequest.getSession(true).setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
        );

        return "Session Login successful";
    }

    @GetMapping("/whoami")
    public String whoami() {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        return auth.getName();
    }

//    @GetMapping("/youKnowWhoIAm")
//    public String whoIAm(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return auth.getName();
//    }



}
