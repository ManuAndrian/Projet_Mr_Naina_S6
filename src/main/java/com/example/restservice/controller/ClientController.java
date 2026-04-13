package com.example.restservice.controller;

import com.example.restservice.entity.Client;
import com.example.restservice.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // GET all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
        public String createClient(@ModelAttribute Client client,Model model) {
        clientService.createClient(client);
         model.addAttribute("message", "Client créé avec succès !");
            return "clients";       
        }
}
