package com.example.restservice.service;

import com.example.restservice.entity.Correcteur;
import com.example.restservice.repository.CorrecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorrecteurService {
    
    @Autowired
    private CorrecteurRepository correcteurRepository;
    
    // CREATE
    public Correcteur saveCorrecteur(Correcteur correcteur) {
        return correcteurRepository.save(correcteur);
    }
    
    // READ ALL
    public List<Correcteur> getAllCorrecteurs() {
        return correcteurRepository.findAll();
    }
    
    // READ BY ID
    public Optional<Correcteur> getCorrecteurById(Integer id) {
        return correcteurRepository.findById(id);
    }
    
    // UPDATE
    public Correcteur updateCorrecteur(Integer id, Correcteur correcteurDetails) {
        Optional<Correcteur> correcteurOptional = correcteurRepository.findById(id);
        if (correcteurOptional.isPresent()) {
            Correcteur correcteur = correcteurOptional.get();
            correcteur.setNom(correcteurDetails.getNom());
            correcteur.setPrenom(correcteurDetails.getPrenom());
            correcteur.setEmail(correcteurDetails.getEmail());
            correcteur.setTelephone(correcteurDetails.getTelephone());
            correcteur.setSpecialite(correcteurDetails.getSpecialite());
            return correcteurRepository.save(correcteur);
        }
        return null;
    }
    
    // DELETE
    public boolean deleteCorrecteur(Integer id) {
        if (correcteurRepository.existsById(id)) {
            correcteurRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Méthodes supplémentaires
    public Optional<Correcteur> findByEmail(String email) {
        return correcteurRepository.findByEmail(email);
    }
    
    public List<Correcteur> findBySpecialite(String specialite) {
        return correcteurRepository.findBySpecialite(specialite);
    }
}
