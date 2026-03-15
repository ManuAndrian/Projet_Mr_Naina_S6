package com.example.restservice.service;

import com.example.restservice.entity.Note;
import com.example.restservice.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    
    @Autowired
    private NoteRepository noteRepository;
    
    // CREATE
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }
    
    // READ ALL
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    
    // READ BY ID
    public Optional<Note> getNoteById(Integer id) {
        return noteRepository.findById(id);
    }
    
    // UPDATE
    public Note updateNote(Integer id, Note noteDetails) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            note.setCandidat(noteDetails.getCandidat());
            note.setMatiere(noteDetails.getMatiere());
            // note.setCorrecteur(noteDetails.getCorrecteur());
            note.setValeur(noteDetails.getValeur());
            note.setDateEvaluation(noteDetails.getDateEvaluation());
            return noteRepository.save(note);
        }
        return null;
    }
    
    // DELETE
    public boolean deleteNote(Integer id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Méthodes supplémentaires
    public List<Note> findByCandidat(Integer idCandidat) {
        return noteRepository.findByCandidat_IdCandidat(idCandidat);
    }
    
    public List<Note> findByMatiere(Integer idMatiere) {
        return noteRepository.findByMatiere_IdMatiere(idMatiere);
    }

    public List<Note> findByCandidatAndByMatiere(Integer idCandidat, Integer idMatiere){
        return noteRepository.findByCandidat_IdCandidatAndMatiere_IdMatiere(idCandidat,idMatiere);
    }

    // Recherche par correcteur (commenté car l'entité n'existe pas)
    // public List<Note> findByCorrecteur(Integer idCorrecteur) {
    //     return noteRepository.findByCorrecteur_IdCorrecteur(idCorrecteur);
    // }
    
    public List<Note> findByDateEvaluation(LocalDate date) {
        return noteRepository.findByDateEvaluation(date);
    }
    
    public List<Note> findByValeurGreaterThan(BigDecimal valeur) {
        return noteRepository.findByValeurGreaterThan(valeur);
    }

    // TRAITEMENT SUPPLÉMENTAIRE

public BigDecimal calculEcart(List<Note> notes) {
    if (notes == null || notes.size() < 2) {
        return BigDecimal.ZERO; // pas d'écart si moins de 2 notes
    }

    BigDecimal sommeEcart = BigDecimal.ZERO;
    int nbEcart = 0;

    // double boucle pour tous les écarts possibles
    for (int i = 0; i < notes.size(); i++) {
        for (int j = i + 1; j < notes.size(); j++) {
            BigDecimal diff = notes.get(i).getValeur().subtract(notes.get(j).getValeur()).abs();
            sommeEcart = sommeEcart.add(diff);
            nbEcart++;
        }
    }
    return sommeEcart;
    }
}
