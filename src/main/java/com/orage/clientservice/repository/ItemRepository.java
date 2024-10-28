package com.orage.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orage.clientservice.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Custom database queries can be defined here
}
