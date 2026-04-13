package com.example.restservice.controller;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.restservice.entity.Demande;
import com.example.restservice.service.ClientService;
import com.example.restservice.service.DemandeService;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restservice.entity.Client;
import com.example.restservice.entity.TypeDevis;
import com.example.restservice.service.TypeDevisService;

@Controller
public class HomeController {
    
    @Autowired
    ClientService clientService;

    @Autowired 
    DemandeService demandeService;

    @Autowired 
    TypeDevisService typeDevisService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/devis")
    public String devis(Model model) {

        List<TypeDevis> typeDevis = typeDevisService.findAll();
        model.addAttribute("typeDevis", typeDevis);
        return "devis";
    }

    @GetMapping("/client")
    public String client() {
        return "client";
    }

    @GetMapping("/demande")
    public String showDemandeForm(Model model) {
        
        model.addAttribute("demande", new Demande());
        List<Client> clients = clientService.getAllClients();
        List<Demande> demandes = demandeService.getAllDemandeStatutUpdated();
        model.addAttribute("clients", clients);
        model.addAttribute("demandes", demandes);
        return "demande"; 
    }

    @GetMapping("/demande/create")
    public String showDevisCreateForm(Model model) {
        List<TypeDevis> typeDevis = typeDevisService.findAll();
        model.addAttribute("typeDevis", typeDevis);
        return "devis";
    }

}
