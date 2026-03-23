package com.example.restservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restservice.entity.Note;
import com.example.restservice.entity.Operateur;
import com.example.restservice.entity.Parametre;
import com.example.restservice.service.NoteService;
import com.example.restservice.service.ParametreService;


@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private ParametreService parametreService;

// Exemple : http://localhost:8080/finalNote?matiereId=1

@GetMapping("/finalNote")

public String getFinalNote(
        @RequestParam Integer matiereId,
        @RequestParam Integer candidatId,
        Model model) { 
     
    // 1️⃣ Récupérer les notes de l'élève POUR cette matière uniquement
    
    List<Note> notes = noteService.findByCandidatAndByMatiere(candidatId, matiereId); 

    if (notes == null || notes.isEmpty()) {
        throw new IllegalArgumentException("Aucune note trouvée pour cet élève et cette matière !");
    }

    // 2️⃣ Calculer l'écart
    BigDecimal ecart = noteService.calculEcart(notes);

    // 3️⃣ Calculer la note finale
    double noteFinale = parametreService.NoteFinaleEleve(ecart, matiereId, notes);

    // 4️⃣ Ajouter la note finale au Model pour que JSP puisse l'afficher
    model.addAttribute("noteFinale", noteFinale);

    // 5️⃣ Retourner le nom de la JSP
    return "etudiant";  
}
    
}
