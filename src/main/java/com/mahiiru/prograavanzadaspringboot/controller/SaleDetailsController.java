package com.mahiiru.prograavanzadaspringboot.controller;

import com.mahiiru.prograavanzadaspringboot.model.SaleDetails;
import com.mahiiru.prograavanzadaspringboot.service.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/saleDetails")
public class SaleDetailsController {

    @Autowired
    private SaleDetailsService service;

    @GetMapping
    public ResponseEntity<List<SaleDetails>> getAllClients(){
        return ResponseEntity.ok(service.getAllSaleDetails());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Optional<SaleDetails>> getSaleDetailsByID(@PathVariable Long id){
        return ResponseEntity.ok(service.getSaleDetailsByID(id));
    }
    @PostMapping
    public ResponseEntity<Optional<SaleDetails>> postSaleDetails(
            @RequestParam Long bookID,
            @RequestParam int quantity,
            @RequestParam Long clientID){
        return ResponseEntity.ok(service.createAndSaveSaleDetails(bookID,quantity,clientID));
    }
}
