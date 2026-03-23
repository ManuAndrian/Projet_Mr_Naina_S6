package com.example.restservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "id_demande_statut")
public class DemandeStatut {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_demande", nullable = false)
    private Demande demande;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_statut", nullable = false)
    private Statut statut;
    
    @Column(name = "date_statut")
    private LocalDate dateStatut;
    
    // Getters et Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Demande getDemande() {
        return demande;
    }
    
    public void setDemande(Demande demande) {
        this.demande = demande;
    }
    
    public Statut getStatut() {
        return statut;
    }
    
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    
    public LocalDate getDateStatut() {
        return dateStatut;
    }
    
    public void setDateStatut(LocalDate dateStatut) {
        this.dateStatut = dateStatut;
    }
}
