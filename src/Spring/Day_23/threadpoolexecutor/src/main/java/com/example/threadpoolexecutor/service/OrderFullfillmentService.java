package com.example.threadpoolexecutor.service;

//import org.springframework.core.annotation.Order;
import com.example.threadpoolexecutor.dto.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderFullfillmentService {

    private InventoryService inventoryService;
    private PaymentService paymentService;

    public OrderFullfillmentService(InventoryService inventoryService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    public Order processOrder(Order order) throws  InterruptedException{
        order.setTrackingId(UUID.randomUUID().toString());
        if(inventoryService.checkProductAvailability(order.getOrderId())){
            paymentService.processPayment(order);
        }else{
            throw new RuntimeException("Technical issue please retry.");
        }
        return order;
    }

    @Async("asyncTaskExecutor")
    public void notifyUser(Order order) throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("Notified to the user "+Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignVendor(Order order) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("Assign order to vendor"+Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void orderPackaging(Order order) throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("Order packaging is complete "+Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignDeliveryPartner(Order order) throws InterruptedException {
        Thread.sleep(10000L);
        System.out.println("Delivery partner assigned "+Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignTrailer(Order order) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Trailer assigned and order dispatched "+Thread.currentThread().getName());
    }
}
