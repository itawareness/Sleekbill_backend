package com.orage.clientservice.repository;

import com.orage.clientservice.model.PurchaseBillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseBillItemRepository extends JpaRepository<PurchaseBillItem, Long> {
}
