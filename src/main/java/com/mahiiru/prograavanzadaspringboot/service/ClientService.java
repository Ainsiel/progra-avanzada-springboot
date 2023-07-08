package com.mahiiru.prograavanzadaspringboot.service;


import com.mahiiru.prograavanzadaspringboot.model.Client;
import com.mahiiru.prograavanzadaspringboot.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private IClientRepository repository;

    public List<Client> getAllClients(){
        return repository.findAll();
    }

    public Optional<Client> getClientByID(Long id){
        return repository.findById(id);
    }

    private void saveClient(Client c){
        repository.save(c);
    }

    public Optional<Client> saveAndGetClient(String name, String email){
        Client c = createClient(name,email);
        saveClient(c);
        return getClientByEmail(c.getEmail());
    }

    private Client createClient(String name, String email){
        return new Client(name,email);
    }

    private Optional<Client> getClientByEmail(String email) {
        return Optional.ofNullable(repository.findByEmail(email));
    }
}
