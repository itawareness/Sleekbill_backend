package com.orage.clientservice.service;

import com.orage.clientservice.model.PurchaseBill;
import com.orage.clientservice.repository.PurchaseBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseBillService {

    @Autowired
    private PurchaseBillRepository repository;

    public PurchaseBill savePurchaseBill(PurchaseBill purchaseBill) {
        return repository.save(purchaseBill);
    }

    public Optional<PurchaseBill> findPurchaseBillById(Long id) {
        return repository.findById(id);
    }

    public void deletePurchaseBill(Long id) {
        repository.deleteById(id);
    }
}
