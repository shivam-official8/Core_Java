package com.example.caching.repository;

import com.example.caching.model.Product_Caching;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product_Caching, Long> {

}
