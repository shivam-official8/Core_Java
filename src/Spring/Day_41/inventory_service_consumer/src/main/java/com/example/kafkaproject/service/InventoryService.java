package com.example.kafkaproject.service;

import com.example.kafkaproject.entity.Inventory;
import com.example.kafkaproject.entity.Order;
import com.example.kafkaproject.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    private ResponseEntity<String> response;
    String message="";

//    @Autowired
//    private KafkaTemplate<String, Order> kafkaTemplate;

    @KafkaListener(topics = "orders-topic", groupId="inventory-service")
    public void inventoryService(Order order){
        Inventory inventory = inventoryRepo
                .findById(order.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if(order.getQuantity()>inventory.getStock()){
            System.out.println("out of stock");
            response = new ResponseEntity<>("out of stock", HttpStatus.CONFLICT);
        }else{

            inventory.setStock(inventory.getStock()- order.getQuantity());

            inventoryRepo.save(inventory);
            response = new ResponseEntity<>("inventory: "+inventory+" Order: "+order, HttpStatus.OK);
        }
        System.out.println("inventory: "+order);
    }

    public ResponseEntity<String> getResponse(){
        return response;
    }


}
