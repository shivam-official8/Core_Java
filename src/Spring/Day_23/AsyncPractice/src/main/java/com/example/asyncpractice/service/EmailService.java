package com.example.asyncpractice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Async
    public void sendOrderEmail(String email) throws InterruptedException {
        Thread.sleep(50000);
        System.out.println("Order confirm email to - "+email);

    }
}
