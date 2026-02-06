package com.example.jsp_ecommerce.repository;

import com.example.jsp_ecommerce.entity.Users;
import com.example.jsp_ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
