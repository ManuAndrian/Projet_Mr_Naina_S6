package com.example.restservice.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.entity.Note;
import com.example.restservice.entity.Operateur;
import com.example.restservice.entity.Parametre;
import com.example.restservice.entity.Resolution;
import com.example.restservice.repository.ParametreRepository;


@Service
public class ParametreService {
    
@Autowired
    private ParametreRepository parametreRepository;
@Autowired
    private ResolutionService resolutionService;

 public List<Parametre>  findParametreByMatiere(Integer idMatiere) {
        return parametreRepository.findByMatiere_IdMatiere(idMatiere);
    }


 public boolean isOperationCondition(Operateur operateur, BigDecimal ecart, Parametre p){

        switch (operateur.getSigne()) {

            case ">":
                return ecart.compareTo(p.getValeur()) > 0;
            case "<":
                return ecart.compareTo(p.getValeur()) < 0;
            case ">=":
                return ecart.compareTo(p.getValeur()) >= 0;
            case "<=":
                return ecart.compareTo(p.getValeur()) <= 0;
            
            default:
                throw new IllegalArgumentException("Opérateur inconnu: " + operateur.getSigne());
        }
  }

  public Resolution getResolution(Operateur operateur, BigDecimal ecart, List<Parametre> parametres) {
    for (Parametre p : parametres) {
        if (isOperationCondition(operateur, ecart, p)) {
            return p.getResolution();
        }
    }
    return null; // ou une valeur par défaut si aucune condition n'est satisfaite
}

 public double NoteFinaleEleve(BigDecimal ecart, Integer idMatiere, List<Note> notes) {
        if (notes == null || notes.isEmpty()) {
            throw new IllegalArgumentException("La liste des notes est vide !");
        }

        // 1️⃣ Récupérer les paramètres pour la matière
        List<Parametre> parametres = parametreRepository.findByMatiere_IdMatiere(idMatiere);
        if (parametres == null || parametres.isEmpty()) {
            throw new IllegalArgumentException("Aucun paramètre défini pour cette matière !");
        }

        // 2️⃣ Déterminer la résolution applicable en fonction de l'opérateur et de l'écart
        Resolution resolution = null;
        for (Parametre p : parametres) {
            if (isOperationCondition(p.getOperateur(), ecart, p)) {
                resolution = p.getResolution();
                break; // on prend la première correspondante
            }
        }

        if (resolution == null) {
            throw new IllegalStateException("Aucune résolution applicable pour l'écart donné !");
        }

        // 3️⃣ Calculer la note finale selon la résolution
        return resolutionService.getNoteFrom(resolution, notes);

    }
}  