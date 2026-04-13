package com.example.restservice.repository;
import org.springframework.stereotype.Repository;
import com.example.restservice.entity.Devis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface  DevisRepository extends JpaRepository<Devis, Integer>  {

    @Query("SELECT d FROM Devis d LEFT JOIN FETCH d.detailsDevis LEFT JOIN FETCH d.typeDevis LEFT JOIN FETCH d.demande")
    List<Devis> findAllWithDetails();

}
