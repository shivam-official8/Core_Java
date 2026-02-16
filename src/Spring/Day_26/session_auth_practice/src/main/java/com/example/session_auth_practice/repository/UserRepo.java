package com.example.session_auth_practice.repository;

import com.example.session_auth_practice.entity.Userss;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Userss, Long> {
    Optional<Userss> findByUsername(String username);
}