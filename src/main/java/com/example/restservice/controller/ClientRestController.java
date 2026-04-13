package com.example.restservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.entity.Client;
import com.example.restservice.entity.Demande;
import com.example.restservice.service.ClientService;
import com.example.restservice.service.DemandeService;

@RestController
@RequestMapping("rest/ajax/")
public class ClientRestController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/{demandeId}")
    public Client getclientBydemande(@PathVariable Integer demandeId) {
        return clientService.getClientByDemande(demandeId);
    }
}
