package com.example.practice_project.service;

import com.example.practice_project.dto.LoginRequest;
import com.example.practice_project.dto.RegisterRequest;
import com.example.practice_project.entity.Users;
import com.example.practice_project.enums.Role;
import com.example.practice_project.repository.UserRepo;
import com.example.practice_project.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;



    public ResponseEntity<String> register(RegisterRequest req){

        if(repo.findByEmail(req.getEmail()).isPresent())return new ResponseEntity<>("Email already exists.", HttpStatus.CONFLICT);

        Users user = new Users();
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword())); // encode password
        user.setRole(Role.USER);
        user.setUsername(req.getUsername());

        repo.save(user);

        return new ResponseEntity<>("User registered", HttpStatus.CREATED);
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




    public ResponseEntity<String> login(LoginRequest req){

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                req.getEmail(),
                                req.getPassword()
                        )
                );
        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        if(authentication.isAuthenticated()){
            return new ResponseEntity<>(jwtUtil.generateToken(req.getEmail(), role), HttpStatus.OK);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
