package com.example.restservice.repository;

import com.example.restservice.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {
    
    // Recherche par nom de matière
    Optional<Matiere> findByNomMatiere(String nomMatiere);
    
    // Recherche par nom (contient)
    List<Matiere> findByNomMatiereContainingIgnoreCase(String nomMatiere);
    
    // Recherche par coefficient
    List<Matiere> findByCoefficient(Integer coefficient);
}
