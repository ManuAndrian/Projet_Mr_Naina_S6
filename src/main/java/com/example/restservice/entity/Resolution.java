package com.example.restservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Resolution")
public class Resolution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resolution")
    private Integer idResolution;
    
    @Column(name = "nom_resolution", nullable = false, length = 100)
    private String nomResolution;
    
    // Getters et Setters
    public Integer getIdResolution() {
        return idResolution;
    }
    
    public void setIdResolution(Integer idResolution) {
        this.idResolution = idResolution;
    }
    
    public String getNomResolution() {
        return nomResolution;
    }
    
    public void setNomResolution(String nomResolution) {
        this.nomResolution = nomResolution;
    }
}
