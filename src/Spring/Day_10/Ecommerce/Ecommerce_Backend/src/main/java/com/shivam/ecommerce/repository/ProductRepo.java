package com.shivam.ecommerce.repository;

import com.shivam.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.name like concat('%', :keyword, '%')" +
            " or p.description like concat('%', :keyword, '%') or " +
            "p.brand like concat('%', :keyword, '%')")
    List<Product> searchProducts(String keyword);
}
