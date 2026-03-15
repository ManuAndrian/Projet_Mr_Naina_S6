package com.example.restservice.controller;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.restservice.entity.Matiere;
import com.example.restservice.service.CandidatService;
import com.example.restservice.service.MatiereService;
import java.util.List;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restservice.entity.Candidat;

@Controller
public class HomeController {

    @Autowired
   private CandidatService etudiantService;

    @Autowired
    private MatiereService matiereService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/parametre")
    public String parametre() {
        return "parametre";
    }

    @GetMapping("/operateur")
    public String operateur() {
        return "operateur";
    }

    @GetMapping("/etudiant")
    public String etudiant(Model model) {

    List<Candidat> etudiants = etudiantService.getAllCandidats();
    List<Matiere> matieres = matiereService.getAllMatieres();

    model.addAttribute("etudiants", etudiants);
    model.addAttribute("matieres", matieres);

        return "etudiant";
    }
}