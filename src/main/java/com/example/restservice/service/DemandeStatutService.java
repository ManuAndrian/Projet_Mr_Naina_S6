package com.example.restservice.service;

import com.example.restservice.entity.Demande;
import com.example.restservice.entity.DemandeStatut;
import com.example.restservice.entity.Statut;
import com.example.restservice.repository.DemandeStatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DemandeStatutService {

    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    public DemandeStatut creerDemandeStatut(Demande demande, Statut statut) {
        DemandeStatut ds = new DemandeStatut();
        ds.setDemande(demande);
        ds.setStatut(statut);
        ds.setDateStatut(LocalDate.now()); 
        return demandeStatutRepository.save(ds);
    }
}