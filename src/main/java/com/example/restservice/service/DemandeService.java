package com.example.restservice.service;

import com.example.restservice.entity.Demande;
import com.example.restservice.repository.DemandeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {
    
    @Autowired
    private DemandeRepository demandeRepository;
    
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }
    
    public Demande getDemandeById(Integer id) {
    return demandeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Demande introuvable avec l'id : " + id));
}
    
    public Demande createDemande(Demande demande) {
        
        if (demande.getDateDemande() == null) {
            demande.setDateDemande(java.time.LocalDate.now());
        }
        return demandeRepository.save(demande);
    }
    
    public Optional<Demande> updateDemande(Integer id, Demande demandeDetails) {
        Optional<Demande> demandeOptional = demandeRepository.findById(id);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setClient(demandeDetails.getClient());
            demande.setDateDemande(demandeDetails.getDateDemande());
            demande.setLieu(demandeDetails.getLieu());
            demande.setDistrict(demandeDetails.getDistrict());
            return Optional.of(demandeRepository.save(demande));
        }
        return Optional.empty();
    }
    
    public boolean deleteDemande(Integer id) {
        if (demandeRepository.existsById(id)) {
            demandeRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Demande> getDemandesByClient(Integer clientId) {
        return demandeRepository.findByClientId(clientId);
    }
    public List<Demande> getDemandesByDateRange(LocalDate startDate, LocalDate endDate) {
        return demandeRepository.findByDateDemandeBetween(startDate, endDate);
    }
    public List<Demande> searchDemandesByLieu(String lieu) {
        return demandeRepository.findByLieuContaining(lieu);
    }
    public List<Demande> getDemandesByDistrict(String district) {
        return demandeRepository.findByDistrict(district);
    }
    @Transactional
    public List<Demande> getDemandeByClientStatutUpdated(Integer clientId){
        return demandeRepository.getDemandesByClientWithLastStatut(clientId);
    }
    
    public List<Demande> getAllDemandeStatutUpdated(){
        return demandeRepository.getAllDemandeClientwithLastStatut();
    }

    
}
