package com.orage.clientservice.controller;


import com.orage.clientservice.model.Invoices;
import com.orage.clientservice.service.InvoiceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceListController {

    @Autowired
    private InvoiceListService invoiceListService;


    @PostMapping("/createInvoice")
    public ResponseEntity<?> createInvoice(@RequestBody Invoices invoiceDTO) {
        try {
            // Call the service to create and save the invoice
            Invoices savedInvoice = invoiceListService.createInvoice(invoiceDTO);
            return ResponseEntity.ok(savedInvoice);
        } catch (RuntimeException e) {
            // Return meaningful error if something goes wrong
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }



}
