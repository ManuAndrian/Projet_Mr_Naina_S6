package com.example.restservice.service;

import com.example.restservice.entity.Statut;
import com.example.restservice.repository.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatutService {

    @Autowired
    private StatutRepository statutRepository;

 
    public Statut createStatut(String nomStatut) {
        Statut statut = new Statut();
        statut.setStatut(nomStatut);
        return statutRepository.save(statut);
    }

    public Statut getStatutByName(String nomStatut) {
        Optional<Statut> optionalStatut = statutRepository.findByStatut(nomStatut);
        return optionalStatut.orElse(null);
    }

    public Statut getStatutById(Integer id) {
    return statutRepository.findById(id).orElse(null);
}

    /* Statut de creation de chaque objet */

    public String getStatutMatchedWith(int typeObject, int typeStatutbyId, Integer idTypeDevis) {

        if(typeObject == 1 && typeStatutbyId == 1){
            return getStatutById(1).getStatut();
        }else if(typeObject == 2 && idTypeDevis == 1){
            return getStatutById(2).getStatut();
        }else if(typeObject == 2 && idTypeDevis == 2){
            return getStatutById(5).getStatut();        
}
    return null;
}

 public Statut getStatutDevis(int typeStatutbyId, Integer idTypeDevis) {

        if(idTypeDevis == 1){

            return getStatutById(2);

        }else if(idTypeDevis == 2){
            return getStatutById(5);        
}
    return null;
}

    }
