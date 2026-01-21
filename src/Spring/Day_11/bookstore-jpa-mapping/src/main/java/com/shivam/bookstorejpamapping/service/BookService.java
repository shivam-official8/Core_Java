package com.shivam.bookstorejpamapping.service;

import com.shivam.bookstorejpamapping.entity.Book;
import com.shivam.bookstorejpamapping.entity.Library;
import com.shivam.bookstorejpamapping.repository.BookRepo;
import com.shivam.bookstorejpamapping.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo repo;
    @Autowired
    LibraryRepo libraryRepo;
    public void addBook(Book book) {
        Library lib = libraryRepo.findById(book.getLibrary().getId())
                .orElseThrow(() -> new RuntimeException("Library not found"));
        lib.getBooks().add(book);
        book.setLibrary(lib);
        repo.save(book);

    }

    public List<Book> getBooks() {
        return repo.findAll();
    }
}
