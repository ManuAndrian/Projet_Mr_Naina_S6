package com.example.restservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Operateur")
public class Operateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operateur")
    private Integer idOperateur;
    
    @Column(name = "signe", nullable = false, length = 5, unique = true)
    private String signe;
    
    // Getters et Setters
    public Integer getIdOperateur() {
        return idOperateur;
    }
    
    public void setIdOperateur(Integer idOperateur) {
        this.idOperateur = idOperateur;
    }
    
    public String getSigne() {
        return signe;
    }
    
    public void setSigne(String signe) {
        this.signe = signe;
    }
}
