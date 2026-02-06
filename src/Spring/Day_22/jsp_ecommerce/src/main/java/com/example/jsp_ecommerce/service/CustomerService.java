package com.example.jsp_ecommerce.service;

import com.example.jsp_ecommerce.dto.AddToCartRequest;
import com.example.jsp_ecommerce.entity.*;
import com.example.jsp_ecommerce.repository.*;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

//    @Autowired
//    private OrderItemsRepo orderItemsRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Transactional
    public ResponseEntity<String> addToCart(AddToCartRequest addToCartRequest){
        if(addToCartRequest.getQuantity()<=0)throw new RuntimeException("Please select quantity.");
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        Users user = userRepo.findByUsername(username);
        Product product = productRepo.findById(addToCartRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = cartItemRepo.findCartItemByUserIdAndProductId(user.getId(),product.getId());

        if(cartItem!=null){
            if(addToCartRequest.getQuantity()+cartItem.getQuantity()<=product.getInstock()){
                cartItem.setQuantity(addToCartRequest.getQuantity()+cartItem.getQuantity());
                cartItemRepo.save(cartItem);
                return new ResponseEntity<>("Item added to cart!", HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>("This Quantity is not in stock!", HttpStatus.CONFLICT);
            }
        }
        if(addToCartRequest.getQuantity()<=product.getInstock()){
             cartItem = new CartItem(user.getId(), addToCartRequest.getProductId(), addToCartRequest.getQuantity());
             cartItemRepo.save(cartItem);
             return new ResponseEntity<>("Item added to cart!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("This Quantity is not in stock!", HttpStatus.CONFLICT);


    }

    @Transactional
    public ResponseEntity<String> orderNow(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        Users user = userRepo.findByUsername(username);
        List<CartItem> cartItemList = cartItemRepo.findCartItemsByUserId(user.getId());

        if (cartItemList.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Cart is empty");
        }

        List<OrderItems> items = new ArrayList<>();
        Orders orders = new Orders();
        orders.setUserId(user.getId());
        orders.setOrderPlacedAt(LocalDateTime.now());
        double totalPrice = 0.0;

        for(CartItem cartItem:cartItemList){
            Product product = productRepo.findProductById(cartItem.getProductId());
            if (product.getInstock() < cartItem.getQuantity()) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(product.getName() + " is out of stock");
            }
            OrderItems orderItems = new OrderItems();
            orderItems.setOrder(orders);
            orderItems.setProductId(cartItem.getProductId());
            orderItems.setQuantity(cartItem.getQuantity());
            orderItems.setPrice(cartItem.getQuantity()*product.getPrice());
            product.setInstock(product.getInstock()-cartItem.getQuantity());
            totalPrice+=orderItems.getPrice();
            productRepo.save(product);
            items.add(orderItems);
        }
        orders.setTotalPrice(totalPrice);
        orders.setItems(items);
        ordersRepo.save(orders);



        cartItemRepo.deleteCartItemsByUserId(user.getId());

        return new ResponseEntity<>("Order place successfully.", HttpStatus.CREATED);
    }
}
