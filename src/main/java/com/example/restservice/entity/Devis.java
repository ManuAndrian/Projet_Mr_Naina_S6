package com.example.restservice.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Devis")
public class Devis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devis")
    private Integer idDevis;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_typeDevis", nullable = false)
    private TypeDevis typeDevis;
    
    @Column(name = "date_devis")
    private LocalDate dateDevis;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_demande", nullable = false)
    private Demande demande;
    
    @Column(name = "montantTotal", precision = 10, scale = 2)
    private BigDecimal montantTotal;
    
    @OneToMany(mappedBy = "devis", cascade = CascadeType.ALL)
    private List<DetailsDevis> detailsDevis;
    
    // Getters et Setters
    public Integer getIdDevis() {
        return idDevis;
    }
    
    public void setIdDevis(Integer idDevis) {
        this.idDevis = idDevis;
    }
    
    public TypeDevis getTypeDevis() {
        return typeDevis;
    }
    
    public void setTypeDevis(TypeDevis typeDevis) {
        this.typeDevis = typeDevis;
    }
    
    public LocalDate getDateDevis() {
        return dateDevis;
    }
    
    public void setDateDevis(LocalDate dateDevis) {
        this.dateDevis = dateDevis;
    }
    
    public Demande getDemande() {
        return demande;
    }
    
    public void setDemande(Demande demande) {
        this.demande = demande;
    }
    
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
    
    public List<DetailsDevis> getDetailsDevis() {
        return detailsDevis;
    }
    
    public void setDetailsDevis(List<DetailsDevis> detailsDevis) {
        this.detailsDevis = detailsDevis;
    }
}
