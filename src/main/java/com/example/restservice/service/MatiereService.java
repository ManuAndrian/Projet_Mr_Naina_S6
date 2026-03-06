package com.example.restservice.service;

import com.example.restservice.entity.Matiere;
import com.example.restservice.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {
    
    @Autowired
    private MatiereRepository matiereRepository;
    
    // CREATE
    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }
    
    // READ ALL
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }
    
    // READ BY ID
    public Optional<Matiere> getMatiereById(Integer id) {
        return matiereRepository.findById(id);
    }
    
    // UPDATE
    public Matiere updateMatiere(Integer id, Matiere matiereDetails) {
        Optional<Matiere> matiereOptional = matiereRepository.findById(id);
        if (matiereOptional.isPresent()) {
            Matiere matiere = matiereOptional.get();
            matiere.setNomMatiere(matiereDetails.getNomMatiere());
            matiere.setCoefficient(matiereDetails.getCoefficient());
            return matiereRepository.save(matiere);
        }
        return null;
    }
    
    // DELETE
    public boolean deleteMatiere(Integer id) {
        if (matiereRepository.existsById(id)) {
            matiereRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Méthodes supplémentaires
    public Optional<Matiere> findByNomMatiere(String nomMatiere) {
        return matiereRepository.findByNomMatiere(nomMatiere);
    }
}
