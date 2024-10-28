package com.orage.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orage.clientservice.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
