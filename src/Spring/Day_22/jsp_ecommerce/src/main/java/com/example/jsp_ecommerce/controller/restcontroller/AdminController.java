package com.example.jsp_ecommerce.controller.restcontroller;

import com.example.jsp_ecommerce.entity.Orders;
import com.example.jsp_ecommerce.entity.Product;
import com.example.jsp_ecommerce.entity.Users;
import com.example.jsp_ecommerce.service.AdminService;
import com.example.jsp_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/addProduct")
//    public ResponseEntity<String> addProduct(@ModelAttribute Product product){
//        return adminService.addProduct(product);
//    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/updateProduct")
//    public ResponseEntity<String> updateProduct(Product product){
//        adminService.updateProduct(product);
////         model.addAttribute("product", adminService);
//         return new ResponseEntity<>("updated", HttpStatusCode.valueOf(200));
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/deleteProduct/{pid}")
//    public ResponseEntity<String> deleteProduct(@PathVariable long pid){
//        return adminService.deleteProduct(pid);
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addAdmin/{uid}")
    public ResponseEntity<String> addAdmin(@PathVariable long uid){
        return adminService.addAdmin(uid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllUsers")
    public List<Users> allUsers(){
        return adminService.allUsers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allOrders")
    public List<Orders> allOrders(){
        return adminService.allOrders();
    }

}
