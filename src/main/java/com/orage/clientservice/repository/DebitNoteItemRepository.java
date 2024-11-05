package com.orage.clientservice.repository;

import com.orage.clientservice.model.DebitNoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitNoteItemRepository extends JpaRepository<DebitNoteItem, Long> {
}
