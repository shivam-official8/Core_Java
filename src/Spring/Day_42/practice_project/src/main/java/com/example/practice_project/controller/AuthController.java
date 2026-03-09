package com.example.practice_project.controller;

import com.example.practice_project.dto.LoginRequest;
import com.example.practice_project.dto.RegisterRequest;
import com.example.practice_project.entity.Users;
import com.example.practice_project.enums.Role;
import com.example.practice_project.repository.UserRepo;
import com.example.practice_project.security.JwtUtil;
import com.example.practice_project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

   @Autowired
   private AuthService service;

   @Autowired
   private UserRepo repo;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest req){

      return service.register(req);
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req){

      return service.login(req);
    }

    @GetMapping("/check-username")
    public Map<String, Boolean> checkUsername(@RequestParam String username) {
        boolean exists = repo.existsByUsername(username);
        return Map.of("available", !exists);
    }




    //    @PostMapping("/adminregister")
//    public String adminregister(@RequestBody RegisterRequest req){
//
//        Users user = new Users();
//        user.setEmail(req.getEmail());
//        user.setPassword(encoder.encode(req.getPassword())); // encode password
//        user.setRole(Role.ADMIN);
//        user.setUsername(req.getUsername());
//
//        repo.save(user);
//
//        return "Admin registered";
//    }

}
