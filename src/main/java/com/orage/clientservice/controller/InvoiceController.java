//package com.orage.clientservice.controller;
//
//import java.util.List;
//
//import com.orage.clientservice.dto.InvoiceDTO;
//import com.orage.clientservice.model.Invoices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.orage.clientservice.model.Invoice;
//import com.orage.clientservice.service.InvoiceService;
//
//@RestController
//@RequestMapping("/invoices")
////@CrossOrigin(origins = "http://localhost:4200")  // Enable CORS for Angular
//public class InvoiceController {
//
//    @Autowired
//    private InvoiceService invoiceService;
//
//    @PostMapping
//    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
//        Invoice savedInvoice = invoiceService.saveInvoice(invoice);
//        return ResponseEntity.ok(savedInvoice);
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Invoice>> getAllInvoices() {
//        List<Invoice> invoices = invoiceService.getAllInvoices();
//        return ResponseEntity.ok(invoices);
//    }
//
//    //get invoice by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Invoice> getInvoiceById(@PathVariable String id) {
//        Invoice invoice = invoiceService.getInvoiceById(id);
//        return ResponseEntity.ok(invoice);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Invoice> updateInvoice(@PathVariable String id, @RequestBody Invoice invoiceDetails) {
//        Invoice updatedInvoice = invoiceService.updateInvoice(id, invoiceDetails);
//        return updatedInvoice != null ? ResponseEntity.ok(updatedInvoice) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
//        invoiceService.deleteInvoice(id);
//        return ResponseEntity.noContent().build();
//    }
//
//
//
//}
