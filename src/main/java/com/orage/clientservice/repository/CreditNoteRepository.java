package com.orage.clientservice.repository;

import com.orage.clientservice.model.CreditNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditNoteRepository extends JpaRepository<CreditNote, Long> {
    // You can define custom queries here if needed
}