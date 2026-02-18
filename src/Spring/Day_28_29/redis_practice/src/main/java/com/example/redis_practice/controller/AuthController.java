package com.example.redis_practice.controller;

import com.example.redis_practice.dto.LoginRequest;
import com.example.redis_practice.model.Users;
import com.example.redis_practice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest request, HttpSession session) {
//
//        Users user = userService.authenticate(
//                request.getUsername(),
//                request.getPassword()
//        );
//        if (user == null) {
//            return "Invalid credentials";
//        }
//        session.setAttribute("userId", user.getId());
//        session.setAttribute("role", user.getRole());
//
//        return "Login successful";
//    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged out";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session){
        Users user = userService.authenticate(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        if(user == null){
            return "Invalid Credentials";
        }
        session.setAttribute("userId", user.getId());
        session.setAttribute("role", user.getRole());
        return "Login successful";
    }


    @PostMapping("/keka")
    public String keka(@RequestBody int[] arr){
        int k=9;
        int r=0,l=0, sum=0, min=Integer.MAX_VALUE;
        while(r<arr.length){
            sum+=arr[r];
            while(sum==k){
                min=Math.min(min, r-l+1);
                sum-=arr[l];
                l++;
            }
            r++;
        }

        System.out.println(min);
        return min+"";
    }
}
