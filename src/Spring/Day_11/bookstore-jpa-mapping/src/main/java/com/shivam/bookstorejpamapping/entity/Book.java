package com.shivam.bookstorejpamapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "library_id")
//    @JsonBackReference // this will prevent infinite recursion
    @JsonIgnoreProperties("books") // if we dont use either of them it will give stack overflow or infinite recursion bug
    private Library library;
}