package com.orage.clientservice.repository;

import com.orage.clientservice.model.PurchaseBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseBillRepository extends JpaRepository<PurchaseBill, Long> {
}
