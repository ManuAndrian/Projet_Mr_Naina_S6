package com.example.restservice.repository;

import com.example.restservice.entity.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Integer> {
    
    // Recherche par signe
    Optional<Operateur> findBySigne(String signe);
}
