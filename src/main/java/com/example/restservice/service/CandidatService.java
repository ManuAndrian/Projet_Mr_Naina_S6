package com.example.restservice.service;

import com.example.restservice.entity.Candidat;
import com.example.restservice.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {
    
    @Autowired
    private CandidatRepository candidatRepository;
    
    // CREATE
    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }
    
    // READ ALL
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }
    
    // READ BY ID
    public Optional<Candidat> getCandidatById(Integer id) {
        return candidatRepository.findById(id);
    }
    
    // UPDATE
    public Candidat updateCandidat(Integer id, Candidat candidatDetails) {
        Optional<Candidat> candidatOptional = candidatRepository.findById(id);
        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();
            candidat.setNom(candidatDetails.getNom());
            candidat.setPrenom(candidatDetails.getPrenom());
            candidat.setDateNaissance(candidatDetails.getDateNaissance());
            candidat.setEmail(candidatDetails.getEmail());
            candidat.setTelephone(candidatDetails.getTelephone());
            return candidatRepository.save(candidat);
        }
        return null;
    }
    
    // DELETE
    public boolean deleteCandidat(Integer id) {
        if (candidatRepository.existsById(id)) {
            candidatRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Méthodes supplémentaires
    public Optional<Candidat> findByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }
    
    public List<Candidat> findByNom(String nom) {
        return candidatRepository.findByNom(nom);
    }
}
