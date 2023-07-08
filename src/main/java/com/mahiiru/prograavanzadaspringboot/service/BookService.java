package com.mahiiru.prograavanzadaspringboot.service;


import com.mahiiru.prograavanzadaspringboot.model.Book;
import com.mahiiru.prograavanzadaspringboot.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private IBookRepository repository;

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Optional<Book> getBookByID(Long id){
        return repository.findById(id);
    }
    private void saveBook(Book b){
        repository.save(b);
    }

    public Optional<Book> saveAndGetBook(Book b){
        saveBook(b);
        return getBookByIsbn(b.getIsbn());
    }

    private Optional<Book> getBookByIsbn(String isbn) {
        return Optional.ofNullable(repository.findByIsbn(isbn));
    }

    public void reduceBookStockByID(Long id, int quantity){
        Optional<Book> book = getBookByID(id);
        book.ifPresent( b ->
                {
                    b.setStock(b.getStock() - quantity);
                    saveBook(b);
                }
        );
    }
}
