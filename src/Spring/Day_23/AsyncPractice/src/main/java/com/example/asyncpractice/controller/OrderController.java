package com.example.asyncpractice.controller;

import com.example.asyncpractice.service.EmailService;
import com.example.asyncpractice.service.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private EmailService emailService;
    private OrderService orderService;

    public OrderController(EmailService emailService, OrderService orderService) {
        this.emailService = emailService;
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public String placeHolder() throws InterruptedException {
        emailService.sendOrderEmail("user@gmail.com");
        return "order-success";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(){
        orderService.placeOrder();
        return "order placed";
    }
}
