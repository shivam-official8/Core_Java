package com.example.jsp_ecommerce.repository;

import com.example.jsp_ecommerce.entity.OrderItems;
import com.example.jsp_ecommerce.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
}
