package com.orage.clientservice.controller;

import com.orage.clientservice.model.PurchaseBill;
import com.orage.clientservice.service.PurchaseBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/purchase-bills")
public class PurchaseBillController {

    @Autowired
    private PurchaseBillService service;

    @PostMapping
    public ResponseEntity<PurchaseBill> createPurchaseBill(@RequestBody PurchaseBill purchaseBill) {
        PurchaseBill savedPurchaseBill = service.savePurchaseBill(purchaseBill);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPurchaseBill.getId()).toUri();
        return ResponseEntity.created(location).body(savedPurchaseBill);
    }
}
