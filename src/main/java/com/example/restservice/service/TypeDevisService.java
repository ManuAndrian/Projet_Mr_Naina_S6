package com.example.restservice.service;

import com.example.restservice.entity.TypeDevis;
import com.example.restservice.repository.TypeDevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDevisService {
    
    @Autowired
    private TypeDevisRepository typeDevisRepository;
    
    public List<TypeDevis> findAll() {
        return typeDevisRepository.findAll();
    }
    
    public TypeDevis findById(Integer id) {
    return typeDevisRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("TypeDevis introuvable"));
}
    
    public TypeDevis save(TypeDevis typeDevis) {
        return typeDevisRepository.save(typeDevis);
    }
    
    public Optional<TypeDevis> update(Integer id, TypeDevis typeDevisDetails) {
        Optional<TypeDevis> typeDevisOptional = typeDevisRepository.findById(id);
        if (typeDevisOptional.isPresent()) {
            TypeDevis typeDevis = typeDevisOptional.get();
            typeDevis.setType(typeDevisDetails.getType());
            return Optional.of(typeDevisRepository.save(typeDevis));
        }
        return Optional.empty();
    }
}
