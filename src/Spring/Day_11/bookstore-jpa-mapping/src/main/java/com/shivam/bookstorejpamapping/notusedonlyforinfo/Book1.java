package com.shivam.bookstorejpamapping.notusedonlyforinfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book1 {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private double price;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishedDate;

    @ManyToOne
    // Foreign Keys always live on the Many side (the child).
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToMany
    @JoinTable(
            name="book_author",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    // jpa decides other entity based on type of this list field
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(mappedBy = "books")
    private List<Order> orders = new ArrayList<>();
}
