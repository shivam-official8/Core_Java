package com.shivam.bookstorejpamapping.notusedonlyforinfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class BookCategory {
    @Id
    private Integer category;
    private String name;

    // cascade = CascadeType.ALL: This means any action performed on the Category (save, delete, update)
    // will automatically "cascade" to all its Books. If you delete the Category, all its Books are deleted too.
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book1> book1s = new ArrayList<>();
}
