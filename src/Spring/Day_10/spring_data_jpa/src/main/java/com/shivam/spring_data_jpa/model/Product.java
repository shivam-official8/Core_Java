package com.shivam.spring_data_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    private int prodId;
    private String prodName;
    private int price;

    public Product() {
    }
}
