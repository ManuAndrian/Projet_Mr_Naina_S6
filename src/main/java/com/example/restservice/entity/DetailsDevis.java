package com.example.restservice.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DetailsDevis")
public class DetailsDevis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detailsDevis")
    private Integer idDetailsDevis;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_devis", nullable = false)
    private Devis devis;
    
    @Column(name = "description", length = 255)
    private String description;
    
    @Column(name = "prixUnitaire", precision = 10, scale = 2)
    private BigDecimal prixUnitaire;
    
    // Getters et Setters
    public Integer getIdDetailsDevis() {
        return idDetailsDevis;
    }
    
    public void setIdDetailsDevis(Integer idDetailsDevis) {
        this.idDetailsDevis = idDetailsDevis;
    }
    
    public Devis getDevis() {
        return devis;
    }
    
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }
    
    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
