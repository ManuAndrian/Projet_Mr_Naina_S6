package com.example.restservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "travaux")
public class Travaux {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_travaux")
    private Integer idTravaux;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_demande", nullable = false)
    private Demande demande;
    
    @Column(name = "date_travaux")
    private LocalDate dateTravaux;
    
    // Getters et Setters
    public Integer getIdTravaux() {
        return idTravaux;
    }
    
    public void setIdTravaux(Integer idTravaux) {
        this.idTravaux = idTravaux;
    }
    
    public Demande getDemande() {
        return demande;
    }
    
    public void setDemande(Demande demande) {
        this.demande = demande;
    }
    
    public LocalDate getDateTravaux() {
        return dateTravaux;
    }
    
    public void setDateTravaux(LocalDate dateTravaux) {
        this.dateTravaux = dateTravaux;
    }
}
