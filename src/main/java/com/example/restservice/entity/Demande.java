package com.example.restservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Demande")
public class Demande {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demande")
    private Integer idDemande;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;
    
    @Column(name = "date_demande")
    private LocalDate dateDemande;
    
    @Column(name = "lieu", length = 100)
    private String lieu;
    
    @Column(name = "district", length = 100)
    private String district;
    
    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    private List<Devis> devis;
    
    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    private List<Travaux> travaux;
    
    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL)
    private List<DemandeStatut> demandeStatuts;
    
    // Getters et Setters
    public Integer getIdDemande() {
        return idDemande;
    }
    
    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public LocalDate getDateDemande() {
        return dateDemande;
    }
    
    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }
    
    public String getLieu() {
        return lieu;
    }
    
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public String getDistrict() {
        return district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    public List<Devis> getDevis() {
        return devis;
    }
    
    public void setDevis(List<Devis> devis) {
        this.devis = devis;
    }
    
    public List<Travaux> getTravaux() {
        return travaux;
    }
    
    public void setTravaux(List<Travaux> travaux) {
        this.travaux = travaux;
    }
    
    public List<DemandeStatut> getDemandeStatuts() {
        return demandeStatuts;
    }
    
    public void setDemandeStatuts(List<DemandeStatut> demandeStatuts) {
        this.demandeStatuts = demandeStatuts;
    }
}
