package com.orage.clientservice.controller;

import com.orage.clientservice.model.CreditNote;
import com.orage.clientservice.service.CreditNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/credit-notes")
public class CreditNoteController {

    @Autowired
    private CreditNoteService service;

    @PostMapping
    public ResponseEntity<CreditNote> createCreditNote(@RequestBody CreditNote creditNote) {
        CreditNote savedCreditNote = service.saveCreditNote(creditNote);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Base URI of the current request
                .path("/{id}")        // Append path with placeholder
                .buildAndExpand(savedCreditNote.getId()) // Replace placeholder with actual ID
                .toUri(); // Convert to URI

        return ResponseEntity.created(location).body(savedCreditNote); // Return 201 with location header
    }

    @GetMapping
    public List<CreditNote> getAllCreditNotes() {
        return service.findAllCreditNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditNote> getCreditNoteById(@PathVariable Long id) {
        CreditNote creditNote = service.findCreditNoteById(id)
                .orElseThrow(() -> new RuntimeException("Credit Note not found with id " + id));
        return ResponseEntity.ok(creditNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCreditNote(@PathVariable Long id) {
        service.deleteCreditNote(id);
        return ResponseEntity.ok("Credit Note deleted successfully.");
    }
}
