package com.example.ecommerce.controller;

import com.example.ecommerce.dto.AddToCartRequest;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody AddToCartRequest addToCartRequest){
        return customerService.addToCart(addToCartRequest);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/orderNow")
    public ResponseEntity<String> orderNow(){
        return customerService.orderNow();
    }
}
