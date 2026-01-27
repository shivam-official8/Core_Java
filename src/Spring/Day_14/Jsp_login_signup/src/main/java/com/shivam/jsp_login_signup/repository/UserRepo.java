package com.shivam.jsp_login_signup.repository;

import com.shivam.jsp_login_signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

