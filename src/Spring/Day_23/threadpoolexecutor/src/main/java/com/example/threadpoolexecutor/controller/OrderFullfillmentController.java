package com.example.threadpoolexecutor.controller;

import com.example.threadpoolexecutor.service.OrderFullfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.threadpoolexecutor.dto.Order;

@Controller
public class OrderFullfillmentController {
    @Autowired
private OrderFullfillmentService service;

    @PostMapping("/orders")
    public ResponseEntity<Order> processOrder(@RequestBody Order  order) throws InterruptedException {
        service.processOrder(order);
        service.notifyUser(order);
        service.assignVendor(order);
        service.orderPackaging(order);
        service.assignDeliveryPartner(order);
        service.assignTrailer(order);
        return ResponseEntity.ok(order);

    }
}
