package com.example.restservice.service;

import com.example.restservice.entity.Operateur;
import com.example.restservice.repository.OperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperateurService {
    
    @Autowired
    private OperateurRepository operateurRepository;
    
    // CREATE
    public Operateur saveOperateur(Operateur operateur) {
        return operateurRepository.save(operateur);
    }
    
    // READ ALL
    public List<Operateur> getAllOperateurs() {
        return operateurRepository.findAll();
    }
    
    // READ BY ID
    public Optional<Operateur> getOperateurById(Integer id) {
        return operateurRepository.findById(id);
    }
    
    // UPDATE
    public Operateur updateOperateur(Integer id, Operateur operateurDetails) {
        Optional<Operateur> operateurOptional = operateurRepository.findById(id);
        if (operateurOptional.isPresent()) {
            Operateur operateur = operateurOptional.get();
            operateur.setSigne(operateurDetails.getSigne());
            return operateurRepository.save(operateur);
        }
        return null;
    }
    
    // DELETE
    public boolean deleteOperateur(Integer id) {
        if (operateurRepository.existsById(id)) {
            operateurRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Méthodes supplémentaires
    public Optional<Operateur> findBySigne(String signe) {
        return operateurRepository.findBySigne(signe);
    }
}
