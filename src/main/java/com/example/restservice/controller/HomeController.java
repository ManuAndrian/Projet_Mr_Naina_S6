package com.example.restservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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
    public String etudiant() {
        return "etudiant";
    }
}