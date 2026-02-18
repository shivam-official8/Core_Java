package com.example.redis_practice.service;

import com.example.redis_practice.model.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Users authenticate(String username, String password) {

        // Simulated DB check
        if ("shivam".equals(username) && "1234".equals(password)) {
            Users user = new Users();
            user.setId(101L);
            user.setUsername(username);
            user.setRole("USER");
            return user;
        }else if ("shivam1".equals(username) && "1234".equals(password)) {
            Users user = new Users();
            user.setId(102L);
            user.setUsername(username);
            user.setRole("USER");
            return user;
        }
        else if ("shivam2".equals(username) && "1234".equals(password)) {
            Users user = new Users();
            user.setId(103L);
            user.setUsername(username);
            user.setRole("USER");
            return user;
        }

        return null;
    }
}
