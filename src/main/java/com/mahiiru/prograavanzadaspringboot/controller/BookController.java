package com.mahiiru.prograavanzadaspringboot.controller;


import com.mahiiru.prograavanzadaspringboot.model.Book;
import com.mahiiru.prograavanzadaspringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable Long id){
        return ResponseEntity.ok(service.getBookByID(id));
    }

    @PostMapping
    public ResponseEntity<Optional<Book>> postBook(@RequestBody Book b){
        return ResponseEntity.ok(service.saveAndGetBook(b));
    }
}
