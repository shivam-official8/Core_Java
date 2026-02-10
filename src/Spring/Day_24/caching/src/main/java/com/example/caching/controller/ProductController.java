package com.example.caching.controller;

import com.example.caching.model.Product_Caching;
import com.example.caching.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product_Caching> getProductById(@PathVariable Long id) {
        Optional<Product_Caching> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("db/{id}")
    public ResponseEntity<Product_Caching> getProductByIdDB(@PathVariable Long id) {
        Optional<Product_Caching> product = productService.getProductByIdDB(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Product_Caching> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product_Caching createProduct(@RequestBody Product_Caching product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product_Caching> updateProduct(@PathVariable Long id, @RequestBody Product_Caching product) {
        Optional<Product_Caching> existing = productService.getProductById(id);
        if (existing.isPresent()) {
            product.setId(id);
            return ResponseEntity.ok(productService.saveProduct(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product_Caching> product = productService.getProductById(id);
        if (product.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
