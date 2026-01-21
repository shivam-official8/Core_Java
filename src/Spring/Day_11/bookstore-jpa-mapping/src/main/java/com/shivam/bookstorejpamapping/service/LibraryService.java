package com.shivam.bookstorejpamapping.service;

import com.shivam.bookstorejpamapping.entity.Book;
import com.shivam.bookstorejpamapping.entity.Library;
import com.shivam.bookstorejpamapping.repository.BookRepo;
import com.shivam.bookstorejpamapping.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryService {
    @Autowired
    BookRepo repo;
    @Autowired
    LibraryRepo libraryRepo;
    public void addLibrary(Library library) {
        libraryRepo.save(library);

    }

    public List<Library> getLibraries() {
        return libraryRepo.findAll();
    }
}
