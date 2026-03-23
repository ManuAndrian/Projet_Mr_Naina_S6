package com.example.restservice.controller;

import com.example.restservice.entity.Client;
import com.example.restservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // GET client by id
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        return ResponseEntity.notFound().build();
    }

    // POST create client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // PUT update client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client clientDetails) {
        Optional<Client> updatedClient = clientService.updateClient(id, clientDetails);
        if (updatedClient.isPresent()) {
            return ResponseEntity.ok(updatedClient.get());
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET clients by nom (contient)
    @GetMapping("/search/nom")
    public List<Client> getClientsByNom(@RequestParam String nom) {
        return clientService.searchClientsByNom(nom);
    }

    // GET clients by contact
    @GetMapping("/search/contact")
    public List<Client> getClientsByContact(@RequestParam String contact) {
        return clientService.getClientsByContact(contact);
    }
}
