package com.example.restservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Matiere")
public class Matiere {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere")
    private Integer idMatiere;
    
    @Column(name = "nom_matiere", nullable = false, length = 100)
    private String nomMatiere;
    
    @Column(name = "coefficient")
    private Integer coefficient = 1;
    
    // Getters et Setters
    public Integer getIdMatiere() {
        return idMatiere;
    }
    
    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }
    
    public String getNomMatiere() {
        return nomMatiere;
    }
    
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
    
    public Integer getCoefficient() {
        return coefficient;
    }
    
    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }
}
