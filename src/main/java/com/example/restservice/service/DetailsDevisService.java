package com.example.restservice.service;

import com.example.restservice.dto.DetailsDevisDTO;
import com.example.restservice.entity.DetailsDevis;
import com.example.restservice.entity.Devis;

import com.example.restservice.repository.DevisDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

@Service
public class DetailsDevisService {

    @Autowired
    private DevisDetailsRepository detailsDevisRepository;

    @Transactional
    public void enregistrerLignesDevis(Devis devis, List<DetailsDevisDTO> lignes) {
        List<DetailsDevis> detailsToSave = new ArrayList<>();
        
        for (DetailsDevisDTO ligne : lignes) {
            DetailsDevis detail = new DetailsDevis();
            detail.setDevis(devis);
            detail.setDescription(ligne.getDesignation());
            detail.setPrixUnitaire(BigDecimal.valueOf(ligne.getPrixUnitaire()));
            detail.setQuantite(ligne.getQuantite());
            detailsToSave.add(detail);
        }
        
        // Sauvegarder toutes les lignes en une seule fois
        detailsDevisRepository.saveAll(detailsToSave);
    }

     public List<Devis> getAllDevisWithDetails() {
        return detailsDevisRepository.findAllWithDetails();
    }

    public Double getChifreDaffaire(){
        return detailsDevisRepository.calculerMontantTotal();
}
    }