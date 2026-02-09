package com.example.threadpoolexecutor.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public boolean checkProductAvailability(Long orderId) {
        return true;
    }
}
