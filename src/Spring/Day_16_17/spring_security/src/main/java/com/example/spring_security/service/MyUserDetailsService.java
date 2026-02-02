package com.example.spring_security.service;

import com.example.spring_security.model.UserPrincipal;
import com.example.spring_security.model.Users;
import com.example.spring_security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        System.out.println("USER: "+user);
        if(user!=null)return new UserPrincipal(user);
        System.out.println("User not found!");
        throw new UsernameNotFoundException("User not exists!");

    }


}
