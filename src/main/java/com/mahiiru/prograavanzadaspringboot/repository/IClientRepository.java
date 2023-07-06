package com.mahiiru.prograavanzadaspringboot.repository;

import com.mahiiru.prograavanzadaspringboot.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
