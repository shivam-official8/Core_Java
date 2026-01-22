package com.shivam.bookstorejpamapping.controller;

import com.shivam.bookstorejpamapping.entity.Book;
import com.shivam.bookstorejpamapping.entity.Library;
import com.shivam.bookstorejpamapping.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @PostMapping("/addlibrary")
    public void addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
    }

    @GetMapping("/getlibraries")
    public List<Library> getLibraries(){
        return libraryService.getAllLibraries();
    }
}
