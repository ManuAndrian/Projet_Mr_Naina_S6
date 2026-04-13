package com.example.restservice.repository;

import com.example.restservice.entity.Client;
import com.example.restservice.entity.Devis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    List<Client> findByNomContaining(String nom);
    List<Client> findByContact(String contact);

    @Query("SELECT d.client FROM Demande d WHERE d.idDemande = :demandeId")
    Client getClientByDemande(@Param("demandeId") Integer demandeId);
}
