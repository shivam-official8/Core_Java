package com.shivam.spring_data_jpa.service;

import com.shivam.spring_data_jpa.model.Product;
import com.shivam.spring_data_jpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>( Arrays.asList(new Product(101,"phone", 50000),
            new Product(102, "Camera", 70000),
            new Product(103, "GTA V", 1500)));

    @Autowired
    ProductRepo repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }


    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(new Product(-1, "No Such Item Found!", -1));
    }

    public void addProduct(Product product){
        repo.save(product);
    }

    public void updateProduct(Product product) {
        // save checks if product is there then it updates or else it adds
      repo.save(product);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
