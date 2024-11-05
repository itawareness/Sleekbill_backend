package com.orage.clientservice.repository;
import com.orage.clientservice.model.CreditNoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditNoteItemRepository extends JpaRepository<CreditNoteItem, Long> {
    // Additional custom queries can be added here
}