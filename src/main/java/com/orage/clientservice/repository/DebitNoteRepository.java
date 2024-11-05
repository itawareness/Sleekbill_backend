package com.orage.clientservice.repository;

import com.orage.clientservice.model.DebitNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitNoteRepository extends JpaRepository<DebitNote, Long> {
}
