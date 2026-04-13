package com.example.restservice.dto;
import java.util.ArrayList;
import java.util.List;

import com.example.restservice.entity.DetailsDevis;
import com.example.restservice.entity.Devis;

public class DevisCompletDTO {

    private Integer idDemande;
    private Integer idTypeDevis;
    private List<DetailsDevisDTO> details;

    // Getters et setters
    public Integer getIdDemande() { return idDemande; }
    public void setIdDemande(Integer idDemande) { this.idDemande = idDemande; }

    public Integer getIdTypeDevis() { return idTypeDevis; }
    public void setIdTypeDevis(Integer idTypeDevis) { this.idTypeDevis = idTypeDevis; }

    public List<DetailsDevisDTO> getDetails() { return details; }
    public void setDetails(List<DetailsDevisDTO> details) { this.details = details; }

}