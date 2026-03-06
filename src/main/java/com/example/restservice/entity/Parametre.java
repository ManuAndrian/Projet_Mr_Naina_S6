package com.example.restservice.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Parametre")
public class Parametre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametre")
    private Integer idParametre;
    
    @Column(name = "valeur", nullable = false, precision = 10, scale = 2)
    private BigDecimal valeur;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operateur", nullable = false)
    private Operateur operateur;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolution", nullable = false)
    private Resolution resolution;
    
    // Getters et Setters
    public Integer getIdParametre() {
        return idParametre;
    }
    
    public void setIdParametre(Integer idParametre) {
        this.idParametre = idParametre;
    }
    
    public BigDecimal getValeur() {
        return valeur;
    }
    
    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
    
    public Matiere getMatiere() {
        return matiere;
    }
    
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    public Operateur getOperateur() {
        return operateur;
    }
    
    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }
    
    public Resolution getResolution() {
        return resolution;
    }
    
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}
