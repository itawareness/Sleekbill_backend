package com.orage.clientservice.service;

import com.orage.clientservice.model.DebitNote;
import com.orage.clientservice.repository.DebitNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DebitNoteService {

    private final DebitNoteRepository repository;

    // Constructor injection for better testability and configuration
    @Autowired
    public DebitNoteService(DebitNoteRepository repository) {
        this.repository = repository;
    }

    @Transactional  // Ensure method is transactional if it modifies the database
    public DebitNote saveDebitNote(DebitNote debitNote) {
        return repository.save(debitNote);
    }

    public DebitNote findDebitNoteById(Long id) {
        // Directly return DebitNote instead of Optional to simplify service layer usage
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Debit Note not found for id: " + id));
    }

    @Transactional  // Mark transactional to handle database operations safely
    public DebitNote updateDebitNote(Long id, DebitNote debitNoteDetails) {
        DebitNote debitNote = findDebitNoteById(id);  // Using the simplified method that handles exception
        // Update fields as necessary
        debitNote.setClientName(debitNoteDetails.getClientName());
        debitNote.setNumber(debitNoteDetails.getNumber());
        debitNote.setInvoiceNumber(debitNoteDetails.getInvoiceNumber());
        debitNote.setDate(debitNoteDetails.getDate());
        debitNote.setReason(debitNoteDetails.getReason());
        // Continue setting other fields from debitNoteDetails as needed

        return repository.save(debitNote);
    }

    public void deleteDebitNote(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalStateException("Debit Note not found for id: " + id);
        }
        repository.deleteById(id);
    }

    public List<DebitNote> findAllDebitNotes() {
        return repository.findAll();
    }
}
