package com.example.restservice.service;

import com.example.restservice.entity.Resolution;
import com.example.restservice.repository.ResolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResolutionService {
    
    @Autowired
    private ResolutionRepository resolutionRepository;
    
    // CREATE
    public Resolution saveResolution(Resolution resolution) {
        return resolutionRepository.save(resolution);
    }
    
    // READ ALL
    public List<Resolution> getAllResolutions() {
        return resolutionRepository.findAll();
    }
    
    // READ BY ID
    public Optional<Resolution> getResolutionById(Integer id) {
        return resolutionRepository.findById(id);
    }
    
    // UPDATE
    public Resolution updateResolution(Integer id, Resolution resolutionDetails) {
        Optional<Resolution> resolutionOptional = resolutionRepository.findById(id);
        if (resolutionOptional.isPresent()) {
            Resolution resolution = resolutionOptional.get();
            resolution.setNomResolution(resolutionDetails.getNomResolution());
            return resolutionRepository.save(resolution);
        }
        return null;
    }
    
    // DELETE
    public boolean deleteResolution(Integer id) {
        if (resolutionRepository.existsById(id)) {
            resolutionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Méthodes supplémentaires
    public Optional<Resolution> findByNomResolution(String nomResolution) {
        return resolutionRepository.findByNomResolution(nomResolution);
    }
}
