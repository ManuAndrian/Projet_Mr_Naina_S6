package com.example.restservice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;
    
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;
    
    @Column(name = "contact", length = 100)
    private String contact;
    
    @Column(name = "adresse", length = 100)
    private String adresse;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Demande> demandes;
    
    // Getters et Setters
    public Integer getIdClient() {
        return idClient;
    }
    
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public List<Demande> getDemandes() {
        return demandes;
    }
    
    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
