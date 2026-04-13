package com.example.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.dto.DevisCompletDTO;
import com.example.restservice.dto.DevisDTO;
import com.example.restservice.entity.Devis;

import org.springframework.transaction.annotation.Transactional;

@Service
public class DevisCompletService {

  
    @Autowired
    private DetailsDevisService detailsDevisService;

    @Autowired
    private DevisService devisService;

    @Transactional
    public Devis creerDevisAvecDetails(DevisCompletDTO devisComplet) {
    
        DevisDTO devisDTO = new DevisDTO();
        devisDTO.setIdDemande(devisComplet.getIdDemande());
        devisDTO.setIdTypeDevis(devisComplet.getIdTypeDevis());
        Devis devis = devisService.createDevis(devisDTO); 

        if (devisComplet.getDetails() != null && !devisComplet.getDetails().isEmpty()) {
            detailsDevisService.enregistrerLignesDevis(devis, devisComplet.getDetails());
        }
        return devis;
    }
}
