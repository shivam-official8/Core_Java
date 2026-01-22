package com.shivam.bookstorejpamapping.notusedonlyforinfo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Orders")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name="order_books",
            joinColumns=@JoinColumn(name="order_id"),
            inverseJoinColumns=@JoinColumn(name="book_id")
    )
    private List<Book1> book1s = new ArrayList<>();
}
