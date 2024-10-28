package com.orage.clientservice.controller;

import com.orage.clientservice.model.PurchaseOrder;
import com.orage.clientservice.service.PurchaseOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder savedPurchaseOrder = purchaseOrderService.saveOrder(purchaseOrder);
        // Create URI of the newly created resource
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Capture the current context path
                .path("/{id}")        // Append the ID placeholder
                .buildAndExpand(savedPurchaseOrder.getId()) // Replace placeholder with actual ID
                .toUri();

        // Return 201 Created response, with location of the new resource
        return ResponseEntity.created(location).body(savedPurchaseOrder);
    }

    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found with id: " + id));
        return ResponseEntity.ok(purchaseOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePurchaseOrder(@PathVariable Long id) {
        purchaseOrderService.deleteOrder(id);
        return ResponseEntity.ok("Purchase Order deleted successfully.");
    }
}
