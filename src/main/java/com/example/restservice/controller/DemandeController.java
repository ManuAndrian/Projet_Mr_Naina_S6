package com.example.restservice.controller;

import com.example.restservice.entity.Demande;
import com.example.restservice.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    // GET all demandes
    @GetMapping
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    // GET demande by id
    @GetMapping("/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Integer id) {
        Optional<Demande> demande = demandeService.getDemandeById(id);
        if (demande.isPresent()) {
            return ResponseEntity.ok(demande.get());
        }
        return ResponseEntity.notFound().build();
    }

    // POST create demande
    @PostMapping
    public Demande createDemande(@RequestBody Demande demande) {
        return demandeService.createDemande(demande);
    }

    // PUT update demande
    @PutMapping("/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable Integer id, @RequestBody Demande demandeDetails) {
        Optional<Demande> updatedDemande = demandeService.updateDemande(id, demandeDetails);
        if (updatedDemande.isPresent()) {
            return ResponseEntity.ok(updatedDemande.get());
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE demande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Integer id) {
        if (demandeService.deleteDemande(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET demandes by client
    @GetMapping("/search/client/{clientId}")
    public List<Demande> getDemandesByClient(@PathVariable Integer clientId) {
        return demandeService.getDemandesByClient(clientId);
    }

    // GET demandes by date range
    @GetMapping("/search/date")
    public List<Demande> getDemandesByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return demandeService.getDemandesByDateRange(start, end);
    }

    // GET demandes by lieu (contient)
    @GetMapping("/search/lieu")
    public List<Demande> getDemandesByLieu(@RequestParam String lieu) {
        return demandeService.searchDemandesByLieu(lieu);
    }

    // GET demandes by district
    @GetMapping("/search/district")
    public List<Demande> getDemandesByDistrict(@RequestParam String district) {
        return demandeService.getDemandesByDistrict(district);
    }
}
