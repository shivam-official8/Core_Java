package com.shivam.bookstorejpamapping.entity;

//import com.shivam.bookstorejpamapping.entity.notusedonlyforinfo.Book1;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();
}
