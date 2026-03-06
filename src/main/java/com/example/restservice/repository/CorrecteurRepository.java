package com.example.restservice.repository;

import com.example.restservice.entity.Correcteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorrecteurRepository extends JpaRepository<Correcteur, Integer> {
    
    // Recherche par email
    Optional<Correcteur> findByEmail(String email);
    
    // Recherche par spécialité
    List<Correcteur> findBySpecialite(String specialite);
    
    // Recherche par nom et prénom
    List<Correcteur> findByNomAndPrenom(String nom, String prenom);
    
    // Recherche par nom (contient)
    List<Correcteur> findByNomContainingIgnoreCase(String nom);
}
