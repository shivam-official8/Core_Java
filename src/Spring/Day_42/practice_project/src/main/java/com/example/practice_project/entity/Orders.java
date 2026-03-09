package com.example.practice_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private String status;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

    @OneToMany(mappedBy="order")
    private List<OrderItem> items;

    @OneToOne(mappedBy="order")
    private Payment payment;


}
