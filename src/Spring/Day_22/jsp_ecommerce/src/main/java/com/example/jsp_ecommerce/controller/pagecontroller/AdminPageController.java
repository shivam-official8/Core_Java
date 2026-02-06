package com.example.jsp_ecommerce.controller.pagecontroller;

import com.example.jsp_ecommerce.entity.Product;
import com.example.jsp_ecommerce.repository.ProductRepo;
import com.example.jsp_ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminPageController {

    @Autowired
    private AdminService adminService;

    private ProductRepo productRepo;

    public AdminPageController(ProductRepo repo) {
        this.productRepo = repo;
    }

    @GetMapping("/users")
    public String users(Model model) {
        System.out.println(adminService.allUsers().size());
        model.addAttribute("users", adminService.allUsers());
        return "admin-users";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", adminService.allOrders());
        return "admin-orders";
    }

    @GetMapping("/add-product-page")
    public String addProductPage() {
        return "add-product";
    }

    @GetMapping("/updateProductPage/{id}")
    public String updateProduct(@PathVariable long id, Model model) {
        Product product = productRepo.findProductById(id); // fetch product from DB
        model.addAttribute("product", product);             // pass it to JSP
        return "edit-product";                              // JSP page name
    }
    @PostMapping("/updateProduct")
    public String updateProduct(Product product){
        adminService.updateProduct(product);
//         model.addAttribute("product", adminService);
        return "redirect:/home";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product){
        adminService.addProduct(product);
        return "redirect:/home";
    }

    @PostMapping("/deleteProduct/{pid}")
    public String deleteProduct(@PathVariable long pid){
         adminService.deleteProduct(pid);
        return "redirect:/home";
    }

}
