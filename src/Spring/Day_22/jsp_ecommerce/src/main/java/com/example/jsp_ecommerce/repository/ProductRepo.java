package com.example.jsp_ecommerce.repository;

import com.example.jsp_ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    public Product findProductById(Long id);

//    Product getProductById(long id);
}
