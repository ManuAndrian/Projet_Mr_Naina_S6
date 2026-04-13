package com.example.restservice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Statut")
public class Statut {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statut")
    private Integer idStatut;
    
    @Column(name = "statut", nullable = false, length = 100)
    private String statut;
    
    @OneToMany(mappedBy = "statut", cascade = CascadeType.ALL)
    private List<DemandeStatut> demandeStatuts;
    
    // Getters et Setters
    public Integer getIdStatut() {
        return idStatut;
    }
    
    public void setIdStatut(Integer idStatut) {
        this.idStatut = idStatut;
    }
    
    public String getStatut() {
        return statut;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public List<DemandeStatut> getDemandeStatuts() {
        return demandeStatuts;
    }
    
    public void setDemandeStatuts(List<DemandeStatut> demandeStatuts) {
        this.demandeStatuts = demandeStatuts;
    }

}
