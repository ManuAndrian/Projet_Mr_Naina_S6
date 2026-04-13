package com.example.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.entity.Client;
import com.example.restservice.entity.Demande;
import com.example.restservice.entity.Statut;
import com.example.restservice.service.ClientService;
import com.example.restservice.service.DemandeService;
import com.example.restservice.service.DemandeStatutService;
import com.example.restservice.service.StatutService;

@Controller
@RequestMapping("/demande")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @Autowired 
    private StatutService statutService;

    @Autowired 
    private DemandeStatutService demandeStatutService;

    @Autowired
    private ClientService clientService;


@PostMapping("create")
public String createDemande(@ModelAttribute Demande demande, Model model) {

    if (demande.getClient() == null || demande.getClient().getIdClient() == null) {
    throw new RuntimeException("Client non sélectionné !");
}

    Integer clientId = demande.getClient().getIdClient();
    Client client = clientService.getClientById(clientId);
    demande.setClient(client);
    
    // sauvegarde
    demandeService.createDemande(demande);
    Statut statut = statutService.getStatutByName("Demande creer");
    demandeStatutService.creerDemandeStatut(demande, statut);

    List<Client> clients = clientService.getAllClients();
    List<Demande> demandes = demandeService.getDemandeByClientStatutUpdated(clientId);

    model.addAttribute("clients", clients);
    model.addAttribute("demandes", demandes);
    model.addAttribute("message", "Demande créée avec succès !");
    return "demande";
}
    }   
