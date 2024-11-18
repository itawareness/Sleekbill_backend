package com.orage.clientservice.repository;

import com.orage.clientservice.model.Invoices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicesRepository extends JpaRepository<Invoices, Long> {
}
