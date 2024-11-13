package com.orage.clientservice.service;

import com.orage.clientservice.model.PurchaseBill;
import com.orage.clientservice.repository.PurchaseBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseBillService {

    private final PurchaseBillRepository repository;

    // Constructor injection for better dependency management
    @Autowired
    public PurchaseBillService(PurchaseBillRepository repository) {
        this.repository = repository;
    }

    @Transactional  // Ensure method is transactional if it modifies the database
    public PurchaseBill savePurchaseBill(PurchaseBill purchaseBill) {
        return repository.save(purchaseBill);
    }

    public PurchaseBill findPurchaseBillById(Long id) {
        // Directly return PurchaseBill instead of Optional to simplify service layer usage
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Purchase Bill not found for id: " + id));
    }

    @Transactional
    public void deletePurchaseBill(Long id) {
        // Check for the purchase bill's existence before attempting to delete to provide a clear error if not found
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Purchase Bill not found for id: " + id);
        }
        repository.deleteById(id);
    }
}
