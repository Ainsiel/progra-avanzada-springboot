package com.mahiiru.prograavanzadaspringboot.controller;


import com.mahiiru.prograavanzadaspringboot.model.Client;
import com.mahiiru.prograavanzadaspringboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {


    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(service.getAllClients());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClientByID(@PathVariable Long id){
        return ResponseEntity.ok(service.getClientByID(id));
    }
    @PostMapping
    public ResponseEntity<Optional<Client>> postClient(@RequestBody Client c){
        return ResponseEntity.ok(service.saveAndGetClient(c));
    }
}
