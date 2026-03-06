package com.example.kafkaproject.service;

import com.example.kafkaproject.entity.Order;
import com.example.kafkaproject.entity.Payment;
import com.example.kafkaproject.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    private ResponseEntity<String> response;

    @KafkaListener(topics="orders-topic", groupId = "payment-service")
    public void paymentService(Order order){
        Payment payment = new Payment();
        payment.setOrderId(order.getOrderId());
        payment.setStatus("success");
        paymentRepo.save(payment);
        System.out.println("payment: "+order);
        response = new ResponseEntity<>("Payment done for order: "+order.toString() +" payment: "+payment, HttpStatus.OK);
    }

    public ResponseEntity<String> getResponse(){
        return response;
    }

}
