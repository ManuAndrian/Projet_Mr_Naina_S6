package com.example.restservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Candidat")
public class Candidat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidat")
    private Integer idCandidat;
    
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;
    
    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;
    
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
    
    @Column(name = "email", length = 150, unique = true)
    private String email;
    
    @Column(name = "telephone", length = 20)
    private String telephone;
    
    // Getters et Setters
    public Integer getId() {
        return idCandidat;
    }
    
    public Integer getIdCandidat() {
        return idCandidat;
    }
    
    public void setIdCandidat(Integer idCandidat) {
        this.idCandidat = idCandidat;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
