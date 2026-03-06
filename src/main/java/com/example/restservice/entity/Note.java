package com.example.restservice.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Note")
public class Note {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Integer idNote;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidat", nullable = false)
    private Candidat candidat;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_correcteur", nullable = false)
    private Correcteur correcteur;
    
    @Column(name = "valeur", nullable = false, precision = 5, scale = 2)
    private BigDecimal valeur;
    
    @Column(name = "date_evaluation")
    private LocalDate dateEvaluation = LocalDate.now();
    
    // Getters et Setters
    public Integer getIdNote() {
        return idNote;
    }
    
    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }
    
    public Candidat getCandidat() {
        return candidat;
    }
    
    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
    
    public Matiere getMatiere() {
        return matiere;
    }
    
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    public Correcteur getCorrecteur() {
        return correcteur;
    }
    
    public void setCorrecteur(Correcteur correcteur) {
        this.correcteur = correcteur;
    }
    
    public BigDecimal getValeur() {
        return valeur;
    }
    
    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
    
    public LocalDate getDateEvaluation() {
        return dateEvaluation;
    }
    
    public void setDateEvaluation(LocalDate dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }
}
