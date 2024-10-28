package com.orage.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
