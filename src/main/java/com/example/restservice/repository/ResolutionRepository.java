package com.example.restservice.repository;

import com.example.restservice.entity.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResolutionRepository extends JpaRepository<Resolution, Integer> {
    
    // Recherche par nom de résolution
    Optional<Resolution> findByNomResolution(String nomResolution);
    
    // Recherche par nom (contient)
    List<Resolution> findByNomResolutionContainingIgnoreCase(String nomResolution);
}
