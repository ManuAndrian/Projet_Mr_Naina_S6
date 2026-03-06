package com.example.restservice.repository;

import com.example.restservice.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
    
    // Recherche par email
    Optional<Candidat> findByEmail(String email);
    
    // Recherche par nom
    List<Candidat> findByNom(String nom);
    
    // Recherche par nom et prénom
    Optional<Candidat> findByNomAndPrenom(String nom, String prenom);
    
    // Recherche par nom (contient)
    List<Candidat> findByNomContainingIgnoreCase(String nom);
    
    // Recherche par date de naissance
    List<Candidat> findByDateNaissance(LocalDate dateNaissance);
}
