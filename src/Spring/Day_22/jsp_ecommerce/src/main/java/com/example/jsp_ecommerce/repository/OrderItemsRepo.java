package com.example.jsp_ecommerce.repository;

import com.example.jsp_ecommerce.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepo extends JpaRepository<OrderItems, Long> {
}
