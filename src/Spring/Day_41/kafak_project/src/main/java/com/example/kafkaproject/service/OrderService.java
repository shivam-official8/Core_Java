package com.example.kafkaproject.service;

import com.example.kafkaproject.entity.Order;
import com.example.kafkaproject.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public ResponseEntity<String> makeOrder(Order order){

        if(order.getQuantity()<1){
            return new ResponseEntity<>("please select non negative quantity!", HttpStatus.CONFLICT);
        }

        orderRepo.save(order);
        kafkaTemplate.send("orders-topic", order);
        return new ResponseEntity<>("Order placed.", HttpStatus.CREATED);

    }
}
