package com.example.restservice.repository;
import org.springframework.stereotype.Repository;
import com.example.restservice.entity.TypeDevis;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TypeDevisRepository extends JpaRepository<TypeDevis, Integer>{
    
}
