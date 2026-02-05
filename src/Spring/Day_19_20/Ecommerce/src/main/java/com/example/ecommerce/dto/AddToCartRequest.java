package com.example.ecommerce.dto;

import com.example.ecommerce.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {
    private Long productId;
    private Integer quantity;

}
