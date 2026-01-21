package com.shivam.bookstorejpamapping.controller;

import com.shivam.bookstorejpamapping.entity.Book;
import com.shivam.bookstorejpamapping.entity.Library;
import com.shivam.bookstorejpamapping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addbook")
    public void addBook(@RequestBody Book book){
//         bookService.addBook(book);
        ; // attach managed entity
        bookService.addBook(book);
    }


    @GetMapping("/getbooks")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }
}
