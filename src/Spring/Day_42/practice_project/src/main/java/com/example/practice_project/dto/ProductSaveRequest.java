package com.example.practice_project.dto;

import com.example.practice_project.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSaveRequest {
    private String name;
    private String description;
    private int stock;
    private double price;
    private Category category;
}
