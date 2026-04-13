package com.example.restservice.controller;

import com.example.restservice.entity.TypeDevis;
import com.example.restservice.service.TypeDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/typedevis")
public class TypeDevisController {

    @Autowired
    private TypeDevisService typeDevisService;

    // GET all types de devis
    @GetMapping
    public List<TypeDevis> getAllTypesDevis() {
        return typeDevisService.findAll();
    }

    // GET type devis by id
    @GetMapping("/{id}")
    public ResponseEntity<TypeDevis> getTypeDevisById(@PathVariable Integer id) {
        TypeDevis typeDevis = typeDevisService.findById(id);
        if (typeDevis != null) {
            return ResponseEntity.ok(typeDevis);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
    