package com.shivam.bookstorejpamapping.notusedonlyforinfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @Column(name="author_id")
    private Integer id;
    private String name;
    private String bio;

    // When you have a @ManyToMany relationship between two entities (like Book and Author), both sides
    // shouldn't try to manage the relationship table (the "join table"). The mappedBy attribute tells
    // Hibernate: "I am not the boss of this relationship; look at the field named 'authors' in the other
    // class to see how we are linked.
    @ManyToMany(mappedBy = "authors")
    private List<Book1> book1s = new ArrayList<>();

}
