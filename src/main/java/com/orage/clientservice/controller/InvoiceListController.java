package com.orage.clientservice.controller;

import com.orage.clientservice.dto.InvoiceDTO;
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

//    @PostMapping("/createInvoice")
//    public ResponseEntity<Invoices> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
//        Invoices createdInvoice = invoiceListService.createInvoice(invoiceDTO);
//        return ResponseEntity.ok(createdInvoice);
//    }


    @PostMapping("/createInvoice")
    public ResponseEntity<Invoices> createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        if (invoiceDTO.getClientId() == null) {
            return ResponseEntity.badRequest().body(null); // Or throw an exception if preferred
        }

        Invoices createdInvoice = invoiceListService.createInvoice(invoiceDTO);
        return ResponseEntity.ok(createdInvoice);
    }

}
