package com.example.restservice.controller;

import com.example.restservice.dto.DevisCompletDTO;
import com.example.restservice.dto.DevisDTO;
import com.example.restservice.entity.Demande;
import com.example.restservice.entity.DetailsDevis;
import com.example.restservice.entity.Devis;
import com.example.restservice.entity.Statut;
import com.example.restservice.service.DevisService;
import com.example.restservice.service.StatutService;
import com.example.restservice.service.DemandeService;
import com.example.restservice.service.DemandeStatutService;
import com.example.restservice.service.DetailsDevisService;
import com.example.restservice.service.DevisCompletService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ajax")
public class DevisController {

    @Autowired
    private DevisCompletService devisCompletService;

    @Autowired
    private DetailsDevisService detailsDevisService;

    @Autowired
    private DevisService devisService;


     @Autowired
    private DemandeService demandeService;

    @Autowired 
    private StatutService statutService;

    @Autowired 
    private DemandeStatutService demandeStatutService;

  //  @PostMapping("/devis")
   // public ResponseEntity<?> saveDevisData(@RequestBody DevisCompletDTO devisComplet) {
    //    try {
        //    DevisDTO devisDTO = new DevisDTO();
        //    devisDTO.setIdDemande(devisComplet.getIdDemande());
         //   devisDTO.setIdTypeDevis(devisComplet.getIdTypeDevis());

          //  Devis devis = devisService.createDevis(devisDTO);

           // if (devisComplet.getDetails() != null && !devisComplet.getDetails().isEmpty()) {
           //    detailsDevisService.enregistrerLignesDevis(devis, devisComplet.getDetails());
           // }
          //  return ResponseEntity.ok("Devis créé avec succès, id = " + devis.getIdDevis());

        //} catch (Exception e) {
         //   return ResponseEntity.badRequest().body("Erreur lors de la création du devis : " + e.getMessage());
       // }
  //  }

@PostMapping("/devis")
public ResponseEntity<?> saveDevisData(@RequestBody DevisCompletDTO devisComplet) {

    try {
        Devis devis = devisCompletService.creerDevisAvecDetails(devisComplet);
        Demande demande = demandeService.getDemandeById(devisComplet.getIdDemande());
        Statut statut = statutService.getStatutDevis(0, devisComplet.getIdTypeDevis());

        if (statut == null) {
            throw new RuntimeException("Statut non trouvé !");
        }

        demandeStatutService.creerDemandeStatut(demande, statut);
        return ResponseEntity.ok(
            "Devis + statut créé avec succès, id = " + devis.getIdDevis()
        );

    } catch (Exception e) {
        return ResponseEntity.badRequest()
                .body("Erreur : " + e.getMessage());
    }
}

    @GetMapping("/liste")
    @ResponseBody
    public List<Devis> getDevis() {
    return detailsDevisService.getAllDevisWithDetails();
}

    @GetMapping("/liste-details")
    @ResponseBody
    public List<DevisDTO> getAllDevisDTO() {
        return devisService.getAllDevisDTO();
    }

    @GetMapping("/chiffre-affaire")
    @ResponseBody
    public double getChiffreAffaire() {
        Double chiffre = detailsDevisService.getChifreDaffaire();
        return chiffre != null ? chiffre.doubleValue() : 0.0;
    }
}