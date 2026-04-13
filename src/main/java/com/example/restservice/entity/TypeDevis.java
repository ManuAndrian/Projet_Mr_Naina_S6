package com.example.restservice.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TypeDevis")
public class TypeDevis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_typeDevis")
    private Integer idTypeDevis;
    
    @Column(name = "type", nullable = false, length = 100)
    private String type;
    
    @JsonIgnore
    @OneToMany(mappedBy = "typeDevis")
    private List<Devis> devis;
    
    // Getters et Setters
    public Integer getIdTypeDevis() {
        return idTypeDevis;
    }
    
    public void setIdTypeDevis(Integer idTypeDevis) {
        this.idTypeDevis = idTypeDevis;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public List<Devis> getDevis() {
        return devis;
    }
    
    public void setDevis(List<Devis> devis) {
        this.devis = devis;
    }
}
