package com.example.jsp_ecommerce.repository;

import com.example.jsp_ecommerce.entity.CartItem;
import com.example.jsp_ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    public CartItem findCartItemByUserIdAndProductId(Long UserId, Long prodId);

    public List<CartItem> findCartItemsByUserId(Long userId);
    public void deleteCartItemsByUserId(Long userId);
}
