package com.example.jsp_ecommerce.dto;

import com.example.jsp_ecommerce.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {
    private Long productId;
    private Integer quantity;

}
