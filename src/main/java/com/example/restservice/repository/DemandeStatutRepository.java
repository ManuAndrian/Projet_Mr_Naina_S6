package com.example.restservice.repository;

import com.example.restservice.entity.DemandeStatut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeStatutRepository extends JpaRepository<DemandeStatut, Integer> {
}