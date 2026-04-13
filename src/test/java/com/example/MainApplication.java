package com.example;

import com.example.restservice.entity.Demande;
import com.example.restservice.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

import java.util.List;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private DemandeService demandeService; // 🔥 ton service sera injecté correctement

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE); // Pas de serveur web
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        Integer clientId = 1; // ID du client que tu veux tester

        // Récupération des demandes
        List<Demande> demandes = demandeService.getDemandeByClientStatutUpdated(clientId);

        // Affichage pour vérifier les données
        System.out.println("Nombre de demandes récupérées : " + demandes.size());
        for (Demande d : demandes) {
            System.out.println("======================================");
            System.out.println("Demande ID : " + d.getIdDemande());
            System.out.println("Client : " + (d.getClient() != null ? d.getClient().getNom() : "null"));
            System.out.println("Date Demande : " + d.getDateDemande());
            System.out.println("Lieu : " + d.getLieu());
            System.out.println("District : " + d.getDistrict());
            
            if (d.getDemandeStatuts() != null) {
                System.out.println("Statuts :");
                d.getDemandeStatuts().forEach(ds -> 
                    System.out.println("  - " + (ds.getStatut() != null ? ds.getStatut().getStatut() : "null") 
                                      + " (" + ds.getDateStatut() + ")")
                );
            } else {
                System.out.println("Statuts : null");
            }
        }
    }
}