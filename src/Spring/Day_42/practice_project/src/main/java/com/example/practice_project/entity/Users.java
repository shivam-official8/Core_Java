package com.example.practice_project.entity;

import com.example.practice_project.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String email;
    private Role role;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
}
