package com.example.restservice.service;

import com.example.restservice.entity.Devis;
import com.example.restservice.repository.DevisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.service.DemandeService;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.example.restservice.dto.*;
import com.example.restservice.entity.Demande;
import com.example.restservice.entity.TypeDevis;
import com.example.restservice.entity.DetailsDevis;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;

    @Autowired 
    private TypeDevisService typeDevisService;

    @Autowired 
    DemandeService demandeService;

    @Autowired 
    StatutService statutService;

    public Devis save(Devis devis) {
        return devisRepository.findAll();
    }

    public Optional<Devis> findById(Integer id) {
        return devisRepository.findById(id);
    }

    public void deleteById(Integer id) {
        devisRepository.deleteById(id);
    }

    public Devis update(Integer id, Devis newDevis) {
        return devisRepository.findById(id)
                .map(devis -> {
                    devis.setDateDevis(newDevis.getDateDevis());
                    devis.setMontantTotal(newDevis.getMontantTotal());
                    devis.setTypeDevis(newDevis.getTypeDevis());
                    devis.setDemande(newDevis.getDemande());
                    return devisRepository.save(devis);
                })
                .orElseThrow(() -> new RuntimeException("Devis non trouvé"));
    }

  public Devis createDevisByDTO(DevisDTO devisDTO) {
    Devis devis = new Devis(); 

    Demande d = demandeService.getDemandeById(devisDTO.getIdDemande());     
    TypeDevis td = typeDevisService.findById(devisDTO.getIdTypeDevis());    

    devis.setDemande(d);
    devis.setTypeDevis(td);

    return devis;
}

    public Devis createDevis(DevisDTO devisDTO) {
        Devis devis = createDevisByDTO(devisDTO);  
        if (devis.getDateDevis() == null) {
            devis.setDateDevis(java.time.LocalDate.now());
        }
        
        String statut = statutService.getStatutMatchedWith(2, 1, devisDTO.getIdTypeDevis());
        devis.setStatut(statut);
        
        return devisRepository.save(devis);
        }

    public List<DevisDTO> getAllDevisDTO() {
        List<Devis> devisList = devisRepository.findAllWithDetails();
        List<DevisDTO> result = new ArrayList<>();

        for (Devis devis : devisList) {
            DevisDTO dto = new DevisDTO();
            dto.setIdDevis(devis.getIdDevis());
            
            if (devis.getDemande() != null) {
                dto.setIdDemande(devis.getDemande().getIdDemande());
            }
            
            if (devis.getTypeDevis() != null) {
                dto.setIdTypeDevis(devis.getTypeDevis().getIdTypeDevis());
                dto.setType(devis.getTypeDevis().getType());
            }
            
            dto.setDateDevis(devis.getDateDevis());
            dto.setMontantTotal(devis.getMontantTotal());

            List<DetailsDevisDTO> detailsList = new ArrayList<>();
            if (devis.getDetailsDevis() != null) {
                for (DetailsDevis d : devis.getDetailsDevis()) {
                    DetailsDevisDTO ddto = new DetailsDevisDTO();
                    ddto.setDesignation(d.getDescription());
                    ddto.setPrixUnitaire(d.getPrixUnitaire().doubleValue());
                    ddto.setQuantite(d.getQuantite());
                    detailsList.add(ddto);
                }
            }
            dto.setDetails(detailsList);

            result.add(dto);
        }
        return result;
    }
}