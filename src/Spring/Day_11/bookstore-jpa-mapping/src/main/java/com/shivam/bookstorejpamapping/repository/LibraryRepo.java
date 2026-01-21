package com.shivam.bookstorejpamapping.repository;

import com.shivam.bookstorejpamapping.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {
}
