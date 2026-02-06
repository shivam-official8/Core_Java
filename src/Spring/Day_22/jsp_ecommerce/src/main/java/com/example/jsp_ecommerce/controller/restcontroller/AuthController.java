package com.example.jsp_ecommerce.controller.restcontroller;

import com.example.jsp_ecommerce.entity.Users;
//import com.example.jsp_ecommerce.enum.Role;
//import com.example.ecommerce.service.AuthService;
//import com.example.ecommerce.service.UserService;
import com.example.jsp_ecommerce.enums.Role;
import com.example.jsp_ecommerce.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String name,
            HttpSession session
    ) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setRole(Role.CUSTOMER);


        userRepository.save(user);
        session.setAttribute("user", user);
        return "redirect:/login";
    }





//    @GetMapping("/home")
//    public String homePage() {
//        return "home";
//    }
}
