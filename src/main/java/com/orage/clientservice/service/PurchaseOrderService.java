package com.orage.clientservice.service;

import com.orage.clientservice.model.PurchaseOrder;
import com.orage.clientservice.repository.PurchaseOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repository;

    public PurchaseOrder saveOrder(PurchaseOrder order) {
        return repository.save(order);
    }

    public List<PurchaseOrder> getAllOrders() {
        return repository.findAll();
    }

    public Optional<PurchaseOrder> getOrderById(Long id) {
        return repository.findById(id);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
