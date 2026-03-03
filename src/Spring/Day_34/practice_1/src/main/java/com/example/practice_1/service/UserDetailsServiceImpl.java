package com.example.practice_1.service;

import com.example.practice_1.model.Users;
import com.example.practice_1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // must be BCrypt encoded
                .roles("USER")
                .build();
    }
}