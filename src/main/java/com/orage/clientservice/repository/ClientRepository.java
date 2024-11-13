package com.orage.clientservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByCompanyNameContainingIgnoreCase(String companyName, Pageable pageable);



    // Custom query to delete clients by their IDs
    void deleteAllByIdIn(List<Long> ids);
}

