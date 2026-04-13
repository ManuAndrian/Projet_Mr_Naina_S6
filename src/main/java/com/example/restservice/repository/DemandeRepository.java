package com.example.restservice.repository;

import com.example.restservice.entity.Demande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import com.example.restservice.entity.Client;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {
    
    @Query("SELECT d FROM Demande d WHERE d.client.idClient = :clientId")
    List<Demande> findByClientId(@Param("clientId") Integer clientId);


    List<Demande> findByDateDemandeBetween(LocalDate startDate, LocalDate endDate);
    List<Demande> findByLieuContaining(String lieu);
    List<Demande> findByDistrict(String district);

       @Query("""
    SELECT DISTINCT d FROM Demande d
    JOIN FETCH d.client
    JOIN FETCH d.demandeStatuts ds
    JOIN FETCH ds.statut
    WHERE d.client.idClient = :clientId
    AND ds.id = (
        SELECT MAX(ds2.id) FROM DemandeStatut ds2 WHERE ds2.demande = d
    )
""")
List<Demande> getDemandesByClientWithLastStatut(@Param("clientId") Integer clientId);

@Query("""
    SELECT DISTINCT d FROM Demande d
    JOIN FETCH d.client
    JOIN FETCH d.demandeStatuts ds
    JOIN FETCH ds.statut
    WHERE ds.id = (
        SELECT MAX(ds2.id)
        FROM DemandeStatut ds2
        WHERE ds2.demande = d
    )
""")
List<Demande> getAllDemandeClientwithLastStatut();

}
