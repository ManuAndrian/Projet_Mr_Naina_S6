package com.example.restservice.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restservice.entity.DetailsDevis;
import com.example.restservice.entity.Devis;


@Repository
public interface  DevisDetailsRepository extends JpaRepository<DetailsDevis, Integer>  {

@Query("SELECT DISTINCT d FROM Devis d LEFT JOIN FETCH d.detailsDevis LEFT JOIN FETCH d.typeDevis")
List<Devis> findAllWithDetails();

 @Query("SELECT SUM(dd.prixUnitaire * dd.quantite) FROM DetailsDevis dd");
    Double calculerMontantTotal();
}
