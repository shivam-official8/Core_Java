package com.shivam.simpleWebApp.service;

import com.shivam.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>( Arrays.asList(new Product(101,"phone", 50000),
            new Product(102, "Camera", 70000),
            new Product(103, "GTA V", 1500)));

    public List<Product> getProducts(){

    return products;
    }


    public Product getProductById(int prodId) {
//        return products.stream().filter(p -> p.getProdId()==prodId).findFirst().get();
        return products.stream().filter(p -> p.getProdId()==prodId).findFirst().orElse(new Product(-1, "No Item Found", -1));
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index = -1;
        for(int i = 0;i<products.size();i++){
            if(products.get(i).getProdId()==product.getProdId()){
                index = i;
                break;
            }
        }
        products.set(index, product);
    }

    public void deleteProduct(int prodId) {
        int index = -1;
        for(int i = 0;i<products.size();i++){
            if(products.get(i).getProdId()==prodId){
                index = i;
                break;
            }
        }
        products.remove(index);
    }
}
