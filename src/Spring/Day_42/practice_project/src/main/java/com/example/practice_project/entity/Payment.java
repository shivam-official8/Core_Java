package com.example.practice_project.entity;

import com.example.practice_project.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentMode paymentMode;
    private int transactionId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;
}
