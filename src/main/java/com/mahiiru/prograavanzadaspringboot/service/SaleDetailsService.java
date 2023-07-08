package com.mahiiru.prograavanzadaspringboot.service;


import com.mahiiru.prograavanzadaspringboot.model.Book;
import com.mahiiru.prograavanzadaspringboot.model.Client;
import com.mahiiru.prograavanzadaspringboot.model.SaleDetails;
import com.mahiiru.prograavanzadaspringboot.repository.ISaleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleDetailsService {

    @Autowired
    private ISaleDetailsRepository repository;

    @Autowired
    private BookService bookService;
    @Autowired
    private ClientService clientService;


    public List<SaleDetails> getAllSaleDetails(){
        return repository.findAll();
    }

    public Optional<SaleDetails> getSaleDetailsByID(Long id){
        return repository.findById(id);
    }

    private void saveSaleDetails(SaleDetails s){
        repository.save(s);
    }

    private Optional<SaleDetails> createSaleDetails(Long bookID, int quantity, Long clientID){
        Optional<Book> book = bookService.getBookByID(bookID);
        Optional<Client> client = clientService.getClientByID(clientID);
        if (book.isPresent() && client.isPresent()){
            if (book.get().getStock() - quantity >= 0) {
                bookService.reduceBookStockByID(bookID,quantity);
                return Optional.of(new SaleDetails(book.get(),quantity,client.get()));
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<SaleDetails> createAndSaveSaleDetails(Long bookID, int quantity, Long clientID){
        Optional<SaleDetails> s = createSaleDetails(bookID,quantity,clientID);
        if (s.isPresent()){
            saveSaleDetails(s.get());
            return s;
        } else {
            return Optional.empty();
        }
    }
}
