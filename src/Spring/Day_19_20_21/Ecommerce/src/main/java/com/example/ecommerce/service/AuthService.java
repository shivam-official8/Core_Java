package com.example.ecommerce.service;

import com.example.ecommerce.entity.Users;
import com.example.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public ResponseEntity<String> register(Users users){
        if(userRepo.findByUsername(users.getUsername())!=null)return new ResponseEntity<>("User Already Exists!", HttpStatus.ALREADY_REPORTED);
        users.setPassword(encoder.encode(users.getPassword()));
        userRepo.save(users);
        return new ResponseEntity<>("User Register", HttpStatus.CREATED);
    }

    public String verify(Users users) {

        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        users.getUsername(),
                        users.getPassword()
                )
        );

        if (auth.isAuthenticated()) {

            UserDetails principal = (UserDetails) auth.getPrincipal();

            String username = principal.getUsername();

            // Extract role from authorities
            String role = principal.getAuthorities()
                    .iterator()
                    .next()
                    .getAuthority()      // ROLE_ADMIN
                    .replace("ROLE_", ""); // ADMIN
            System.out.println("kjcbsdkj"+role);

            return jwtService.generateToken(username, role);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
