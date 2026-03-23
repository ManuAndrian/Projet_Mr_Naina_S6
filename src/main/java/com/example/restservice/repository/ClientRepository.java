package com.example.restservice.repository;

import com.example.restservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    List<Client> findByNomContaining(String nom);
    
    List<Client> findByContact(String contact);
}
