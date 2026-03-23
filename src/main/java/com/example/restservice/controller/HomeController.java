package com.example.restservice.controller;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;


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

    @GetMapping("/client")
    public String client() {
        return "client";
    }

    @GetMapping("/demande")
    public String demande() {
        return "demande";
    }
}
