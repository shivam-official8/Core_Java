package com.example.threadpoolexecutor.service;

//import org.springframework.core.annotation.Order;
import com.example.threadpoolexecutor.dto.Order;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {


    public void processPayment(Order order) throws InterruptedException {
        System.out.println("Initiated payment for order "+order.getClass());

        Thread.sleep(2000L);

        System.out.println("complete payment for order "+order.getClass());
    }
}
