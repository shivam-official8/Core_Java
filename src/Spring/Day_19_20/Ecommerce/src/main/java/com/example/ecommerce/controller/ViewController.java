//package com.example.ecommerce.controller;
//
//import com.example.ecommerce.entity.Product;
//import com.example.ecommerce.entity.Users;
//import com.example.ecommerce.repository.CartItemRepo;
//import com.example.ecommerce.repository.ProductRepo;
//import com.example.ecommerce.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.Scanner;
//
//@Controller
//public class ViewController {
//
//    @Autowired
//    private ProductRepo productRepo;
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private CartItemRepo cartItemRepo;
//
//    @GetMapping("/")
//    public String root(Authentication auth) {
//        return (auth == null) ? "login" : "redirect:/home";
//    }
//
//    @GetMapping("/home")
//    public String home(Model model, Authentication auth) {
//        model.addAttribute("products", productRepo.findAll());
//        model.addAttribute("isAdmin",
//                auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
//        model.addAttribute("isCustomer",
//                auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_CUSTOMER")));
//        return "home";
//    }
//
//    @GetMapping("/cart")
//    public String cart(Model model, Authentication auth) {
//        Users user = userRepo.findByUsername(auth.getName());
//        model.addAttribute("cartItems",
//                cartItemRepo.findCartItemsByUserId(user.getId()));
//        return "cart";
//    }
//
//    // ADMIN
//    @GetMapping("/admin/products")
//    public String adminProducts(Model model) {
//        model.addAttribute("products", productRepo.findAll());
//        return "admin-products";
//    }
//
//    @GetMapping("/admin/products/add")
//    public String addProductPage() {
//        return "add-product";
//    }
//
//    @PostMapping("/admin/products/add")
//    public String addProduct(Product product) {
//        productRepo.save(product);
//        return "redirect:/admin/products";
//    }
//
//    @GetMapping("/admin/products/edit/{id}")
//    public String editProduct(@PathVariable Long id, Model model) {
//        model.addAttribute("product", productRepo.findById(id).get());
//        return "edit-product";
//    }
//
//    @PostMapping("/admin/products/update")
//    public String updateProduct(Product product) {
//        productRepo.save(product);
//        return "redirect:/admin/products";
//    }
//
//    @GetMapping("/admin/products/delete/{id}")
//    public String deleteProduct(@PathVariable Long id) {
//        productRepo.deleteById(id);
//        return "redirect:/admin/products";
//    }
//}
