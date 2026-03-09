package com.example.practice_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
