package com.shivam.simpleWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
@ToString
public class Product {
    private int prodId;
    private String prodName;
    private int price;

    public Product() {
    }
}
