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
    private  LibraryRepo libraryRepository;

    public void addLibrary(Library library) {
         libraryRepository.save(library);
    }


    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }
}