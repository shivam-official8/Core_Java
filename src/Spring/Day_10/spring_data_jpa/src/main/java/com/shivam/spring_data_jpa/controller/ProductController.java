package com.shivam.spring_data_jpa.controller;

import com.shivam.spring_data_jpa.model.Product;
import com.shivam.spring_data_jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService service;

    //    @RequestMapping("/products")
    @GetMapping("/products")
    public List<Product> getProducts(){

        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProdctById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        System.out.println(product);
        service.addProduct(product);

    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        service.updateProduct(product);
    }

    // name in url should be same as name in method parameter or else we need to write @PathVariable("new_name")
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
