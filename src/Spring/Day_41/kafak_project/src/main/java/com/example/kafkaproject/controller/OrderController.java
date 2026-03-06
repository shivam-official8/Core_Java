package com.example.kafkaproject.controller;

import com.example.kafkaproject.entity.Order;
import com.example.kafkaproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<String> makeOrder(@RequestBody Order order){
        return orderService.makeOrder(order);
    }
}
