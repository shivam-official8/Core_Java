package com.shivam.bookstorejpamapping.notusedonlyforinfo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy="customer", cascade= CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}

