package com.example.restservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.Utils.FonctionUtils;
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
    return null; 
}

public List<Parametre> getAllParameterOfConditionTrue(Operateur operateur, BigDecimal ecart, List<Parametre> parametres) {

    List<Parametre> result = new ArrayList<>();

    for (Parametre p : parametres) {
        if (isOperationCondition(operateur, ecart, p)) {
            result.add(p);
        }
    }
    return result;
}

public Parametre getRightParameterBetween(List<Parametre> parametres, double ecart) {

    // Vérification
    if (parametres == null || parametres.isEmpty()) {
        System.err.println("Erreur: La liste de paramètres est null ou vide");
        throw new IllegalArgumentException("La liste ne peut pas être null ou vide");

    }else if(parametres.size() == 1) {
        return parametres.get(0);
    }

    double closest = parametres.get(0).getValeur().doubleValue();
    List<Parametre> PvalueProche = new ArrayList<>();

    for (Parametre p : parametres) {
        double value = p.getValeur().doubleValue();
        
        if (Math.abs(value - ecart) <= Math.abs(closest - ecart)) {
            closest = value;
            PvalueProche.clear();
            PvalueProche.add(p);
        } else if (Math.abs(value - ecart) == Math.abs(closest - ecart)) {
            PvalueProche.add(p);
        }
    }

    if (PvalueProche.size() > 1) {
        PvalueProche.set(0, FonctionUtils.compareMin(PvalueProche));
    }

    if (PvalueProche == null || PvalueProche.isEmpty()) {
        System.err.println("Erreur: Aucune valeur proche trouvée");
        throw new IllegalStateException("Aucune valeur proche n'a été trouvée");
    }
    return PvalueProche.get(0); 
}

 public double NoteFinaleEleve(BigDecimal ecart, Integer idMatiere, List<Note> notes) {
        if (notes == null || notes.isEmpty()) {
            throw new IllegalArgumentException("La liste des notes est vide !");
        }

        List<Parametre> parametres = parametreRepository.findByMatiere_IdMatiere(idMatiere);
        if (parametres == null || parametres.isEmpty()) {
            throw new IllegalArgumentException("Aucun paramètre défini pour cette matière !");
        }

        Resolution resolution = null;

        List<Parametre> parametresFiltres = new ArrayList<>(parametres);
        
        for (Parametre p : parametres) {
             List<Parametre> tempResult = getAllParameterOfConditionTrue(p.getOperateur(), ecart, parametresFiltres);
             if (tempResult != null && !tempResult.isEmpty()) {
                 parametresFiltres = tempResult;
             }
        }
       
        if (parametresFiltres == null || parametresFiltres.isEmpty()) {
            throw new IllegalArgumentException("Aucun paramètre ne correspond aux conditions pour l'écart donné: " + ecart);
        }

        Parametre parametre = getRightParameterBetween(parametresFiltres, ecart.doubleValue());

        if (parametre != null) {
            resolution = parametre.getResolution();
        }           
        if (resolution == null) {
            throw new IllegalStateException("Aucune résolution applicable pour l'écart donné !");
        }

        // 3️⃣ Calculer la note finale selon la résolution
        return resolutionService.getNoteFrom(resolution, notes);
    }
}  


