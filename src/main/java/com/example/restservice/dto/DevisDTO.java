package com.example.restservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DevisDTO {

    private Integer idDevis;
    private Integer idDemande;    
    private Integer idTypeDevis;
    private String type;
    private LocalDate dateDevis;
    private BigDecimal montantTotal;
    private List<DetailsDevisDTO> details;

    // Getter pour idDevis
    public Integer getIdDevis() {
        return idDevis;
    }

    // Setter pour idDevis
    public void setIdDevis(Integer idDevis) {
        this.idDevis = idDevis;
    }

    // Getter pour idDemande
    public Integer getIdDemande() {
        return idDemande;
    }

    // Setter pour idDemande
    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    // Getter pour idTypeDevis
    public Integer getIdTypeDevis() {
        return idTypeDevis;
    }

    // Setter pour idTypeDevis
    public void setIdTypeDevis(Integer idTypeDevis) {
        this.idTypeDevis = idTypeDevis;
    }

    // Getter pour type
    public String getType() {
        return type;
    }

    // Setter pour type
    public void setType(String type) {
        this.type = type;
    }

    // Getter pour dateDevis
    public LocalDate getDateDevis() {
        return dateDevis;
    }

    // Setter pour dateDevis
    public void setDateDevis(LocalDate dateDevis) {
        this.dateDevis = dateDevis;
    }

    // Getter pour montantTotal
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    // Setter pour montantTotal
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    // Getter pour details
    public List<DetailsDevisDTO> getDetails() {
        return details;
    }

    // Setter pour details
    public void setDetails(List<DetailsDevisDTO> details) {
        this.details = details;
    }
}