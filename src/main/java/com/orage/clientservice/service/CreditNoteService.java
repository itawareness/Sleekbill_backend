package com.orage.clientservice.service;

import com.orage.clientservice.model.CreditNote;
import com.orage.clientservice.repository.CreditNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditNoteService {

    @Autowired
    private CreditNoteRepository repository;

    public CreditNote saveCreditNote(CreditNote creditNote) {
        return repository.save(creditNote);
    }

    public List<CreditNote> findAllCreditNotes() {
        return repository.findAll();
    }

    public Optional<CreditNote> findCreditNoteById(Long id) {
        return repository.findById(id);
    }

    public void deleteCreditNote(Long id) {
        repository.deleteById(id);
    }
}
