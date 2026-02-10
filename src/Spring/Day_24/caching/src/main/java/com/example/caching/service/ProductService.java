package com.example.caching.service;


import com.example.caching.model.Product_Caching;
import com.example.caching.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "products", key = "#id")
    public Optional<Product_Caching> getProductById(Long id) {
        System.out.println("Fetching product from database...");
        return productRepository.findById(id);
    }

    public Optional<Product_Caching> getProductByIdDB(Long id) {
        System.out.println("Fetching product from database alwayss...");

        return productRepository.findById(id);
    }

    @CachePut(value = "products", key = "#product.id")
    public Product_Caching saveProduct(Product_Caching product) {
        return productRepository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product_Caching> getAllProducts() {
        return productRepository.findAll();
    }
}