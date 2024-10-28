package com.orage.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.PurchaseOrderItem;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Long> {
}
