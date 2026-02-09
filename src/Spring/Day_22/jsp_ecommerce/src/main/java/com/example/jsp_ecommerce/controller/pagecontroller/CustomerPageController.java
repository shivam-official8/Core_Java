package com.example.jsp_ecommerce.controller.pagecontroller;

import com.example.jsp_ecommerce.dto.AddToCartRequest;
import com.example.jsp_ecommerce.entity.CartItem;
import com.example.jsp_ecommerce.entity.Users;
import com.example.jsp_ecommerce.repository.CartItemRepo;
import com.example.jsp_ecommerce.repository.UserRepo;
import com.example.jsp_ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerPageController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/addToCart")
    public String addToCart(
            @ModelAttribute AddToCartRequest addToCartRequest) {
         customerService.addToCart(addToCartRequest);
        return "redirect:/home";
    }


    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/orderNow")
    public ResponseEntity<String> orderNow(){
        return customerService.orderNow();
    }

    @GetMapping("/cart")
    public String customerCart(Model model){

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();   // logged-in username


        Users user = userRepo.findByUsername(username);

        Long userId = user.getId();
        List<CartItem> cartItems = cartItemRepo.findCartItemsByUserId(userId);
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }
}
