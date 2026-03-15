package com.example.restservice.repository;

import com.example.restservice.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    
    // Recherche par candidat
    List<Note> findByCandidat_IdCandidat(Integer idCandidat);
    
    // Recherche par matière
    List<Note> findByMatiere_IdMatiere(Integer idMatiere);
    
    // Recherche par correcteur (commenté car l'entité n'existe pas)
    // List<Note> findByCorrecteur_IdCorrecteur(Integer idCorrecteur);
    
    // Recherche par candidat et matière
    List<Note> findByCandidat_IdCandidatAndMatiere_IdMatiere(Integer idCandidat, Integer idMatiere);
    
    // Recherche par date d'évaluation
    List<Note> findByDateEvaluation(LocalDate dateEvaluation);
    
    // Recherche par valeur (supérieure à)
    List<Note> findByValeurGreaterThan(BigDecimal valeur);
    
    // Recherche par valeur (entre)
    List<Note> findByValeurBetween(BigDecimal min, BigDecimal max);
}
