package com.example.kafkaproject.entity;

import lombok.Data;

@Data
public class Order {
    private Long orderId;
    private Long productId;
    private int quantity;
    private double amount;
}