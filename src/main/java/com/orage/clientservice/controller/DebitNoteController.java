package com.orage.clientservice.controller;

import com.orage.clientservice.model.DebitNote;
import com.orage.clientservice.service.DebitNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/debit-notes")
public class DebitNoteController {

    @Autowired
    private DebitNoteService service;

    @PostMapping
    public ResponseEntity<DebitNote> createDebitNote(@RequestBody DebitNote debitNote) {
        DebitNote savedDebitNote = service.saveDebitNote(debitNote);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedDebitNote.getId()).toUri();
        return ResponseEntity.created(location).body(savedDebitNote);
    }

    @GetMapping
    public List<DebitNote> getAllDebitNotes() {
        return service.findAllDebitNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DebitNote> getDebitNoteById(@PathVariable Long id) {
        DebitNote debitNote = service.findDebitNoteById(id)
                .orElseThrow(() -> new RuntimeException("Debit Note not found with id " + id));
        return ResponseEntity.ok(debitNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DebitNote> updateDebitNote(@PathVariable Long id, @RequestBody DebitNote debitNoteDetails) {
        DebitNote updatedDebitNote = service.updateDebitNote(id, debitNoteDetails);
        return ResponseEntity.ok(updatedDebitNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDebitNote(@PathVariable Long id) {
        service.deleteDebitNote(id);
        return ResponseEntity.ok("Debit Note deleted successfully.");
    }
}
