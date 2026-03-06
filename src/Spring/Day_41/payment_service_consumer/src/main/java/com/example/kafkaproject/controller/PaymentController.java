package com.example.kafkaproject.controller;

import com.example.kafkaproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getPayment")
    private ResponseEntity<String> getPayment(){
        return paymentService.getResponse();
    }

}
