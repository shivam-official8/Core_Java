package com.shivam.bookstorejpamapping.repository;

import com.shivam.bookstorejpamapping.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
