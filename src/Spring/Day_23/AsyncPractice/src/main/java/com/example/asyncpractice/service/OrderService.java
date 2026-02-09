package com.example.asyncpractice.service;

import com.example.asyncpractice.event.OrderPlacedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void placeOrder(){
        applicationEventPublisher.publishEvent(new OrderPlacedEvent(1L));
    }

}
