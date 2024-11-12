package com.orage.clientservice.service;

import com.orage.clientservice.model.CreditNote;
import com.orage.clientservice.repository.CreditNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditNoteService {

    private final CreditNoteRepository repository;

    // Constructor injection for better dependency management
    @Autowired
    public CreditNoteService(CreditNoteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CreditNote saveCreditNote(CreditNote creditNote) {
        return repository.save(creditNote);
    }

    public List<CreditNote> findAllCreditNotes() {
        return repository.findAll();
    }

    public CreditNote findCreditNoteById(Long id) {
        // Simplify error handling by throwing exception directly if not found
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Credit Note not found for id: " + id));
    }

    @Transactional
    public void deleteCreditNote(Long id) {
        // Check for the credit note's existence before attempting to delete to provide a clear error if not found
        if (!repository.existsById(id)) {
            throw new IllegalStateException("Credit Note not found for id: " + id);
        }
        repository.deleteById(id);
    }
}
