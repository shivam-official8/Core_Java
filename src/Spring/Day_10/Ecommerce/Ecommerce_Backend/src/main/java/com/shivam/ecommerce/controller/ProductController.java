package com.shivam.ecommerce.controller;

import com.shivam.ecommerce.model.Product;
import com.shivam.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin // it removes cors error
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/home")
    public String greet(){
        return "Hello Aliens!...";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProduct(@PathVariable int prodId){
    Product product = service.getProduct(prodId);
    if(product == null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
//    @RequestBody accepts whole obj but @RequestPart accepts data in different parts
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.addProduct(product, imageFile);
//            System.out.println(product1);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println("catch=================================================");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{prodId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int prodId){
        Product product = service.getProduct(prodId);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().body(imageFile);
    }

    @PutMapping("/product/{prodId}")
    public ResponseEntity<String> updateProduct(@PathVariable int prodId, @RequestPart Product product, @RequestPart MultipartFile imageFile){

        Product product1 = null;
        try {
            product1 = service.updateProduct(prodId, product, imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(product1!=null){
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }else{
        return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
    }

    }

    @DeleteMapping("/product/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){
        Product product = service.getProduct(prodId);
        if(product != null){
            service.deleteProduct(prodId);
            return new ResponseEntity<>("Product deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No product found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(String keyword){
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
