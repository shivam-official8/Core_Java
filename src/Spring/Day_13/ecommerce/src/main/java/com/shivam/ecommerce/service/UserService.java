package com.shivam.ecommerce.service;

import com.shivam.ecommerce.entity.UserProfile;
import com.shivam.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    public void addUser(UserProfile userProfile){
//        UserProfile userProfile1 = repo.
        repo.save(userProfile);
    }

    public List<UserProfile> getUsers() {
        return repo.findAll();
    }
}
