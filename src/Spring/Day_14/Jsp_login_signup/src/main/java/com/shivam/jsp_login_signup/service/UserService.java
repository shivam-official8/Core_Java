package com.shivam.jsp_login_signup.service;

import com.shivam.jsp_login_signup.entity.User;
import com.shivam.jsp_login_signup.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;


    public void register(User user) {
        userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        return (user!=null && user.getPassword().equals(password))? user :null;
    }
}

