package com.example.asyncpractice.service;

import com.example.asyncpractice.event.OrderPlacedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @Async
    @EventListener
    public void handleOrder(OrderPlacedEvent event){
        System.out.println("Email +analytics for order "+event.orderId);
    }
}
