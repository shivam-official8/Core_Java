package com.example.asyncpractice.event;

public class OrderPlacedEvent {
    public final Long orderId;

    public OrderPlacedEvent(Long orderId){
        this.orderId = orderId;
    }
}
