package com.example.restservice.repository;

import com.example.restservice.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
    
    // Recherche par matière
    List<Parametre> findByMatiere_IdMatiere(Integer idMatiere);
    
    // Recherche par opérateur
    List<Parametre> findByOperateur_IdOperateur(Integer idOperateur);
    
    // Recherche par résolution
    List<Parametre> findByResolution_IdResolution(Integer idResolution);
    
    // Recherche par valeur (supérieure à)
    List<Parametre> findByValeurGreaterThan(BigDecimal valeur);
    
    // Recherche par valeur (entre)
    List<Parametre> findByValeurBetween(BigDecimal min, BigDecimal max);
    
    // Recherche combinée matière et opérateur
    List<Parametre> findByMatiere_IdMatiereAndOperateur_IdOperateur(Integer idMatiere, Integer idOperateur);
}
