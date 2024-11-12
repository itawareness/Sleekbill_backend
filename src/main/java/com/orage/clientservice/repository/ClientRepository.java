package com.orage.clientservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByCompanyNameContainingIgnoreCase(String companyName, Pageable pageable);
}

