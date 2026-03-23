package com.example.restservice.service;

import com.example.restservice.entity.Client;
import com.example.restservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }
    
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
    
    public Optional<Client> updateClient(Integer id, Client clientDetails) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setNom(clientDetails.getNom());
            client.setContact(clientDetails.getContact());
            client.setAdresse(clientDetails.getAdresse());
            return Optional.of(clientRepository.save(client));
        }
        return Optional.empty();
    }
    
    public boolean deleteClient(Integer id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Client> searchClientsByNom(String nom) {
        return clientRepository.findByNomContaining(nom);
    }
    
    public List<Client> getClientsByContact(String contact) {
        return clientRepository.findByContact(contact);
    }
}
