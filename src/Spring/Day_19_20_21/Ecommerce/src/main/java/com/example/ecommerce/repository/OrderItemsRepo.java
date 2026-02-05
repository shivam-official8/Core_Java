package com.example.ecommerce.repository;

import com.example.ecommerce.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepo extends JpaRepository<OrderItems, Long> {
}
