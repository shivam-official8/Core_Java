package com.example.practice_project.repository;

import com.example.practice_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
