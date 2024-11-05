package com.orage.clientservice.service;

import com.orage.clientservice.model.DebitNote;
import com.orage.clientservice.repository.DebitNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DebitNoteService {

    @Autowired
    private DebitNoteRepository repository;

    public DebitNote saveDebitNote(DebitNote debitNote) {
        return repository.save(debitNote);
    }

    public Optional<DebitNote> findDebitNoteById(Long id) {
        return repository.findById(id);
    }

    public DebitNote updateDebitNote(Long id, DebitNote debitNoteDetails) {
        DebitNote debitNote = findDebitNoteById(id).orElseThrow(() ->
                new IllegalStateException("Debit Note not found for id: " + id));
        debitNote.setClientName(debitNoteDetails.getClientName());
        // Add other fields that need to be updated
        return repository.save(debitNote);
    }

    public void deleteDebitNote(Long id) {
        repository.deleteById(id);
    }

    public List<DebitNote> findAllDebitNotes() {
        return repository.findAll();
    }
}
