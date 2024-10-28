package com.orage.clientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orage.clientservice.model.Invoice;
import com.orage.clientservice.repository.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);

    }
    

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
    
    public Invoice getInvoiceById(String id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }
    // Update an existing invoice
    public Invoice updateInvoice(String id, Invoice invoiceDetails) {
        // Fetch the existing invoice
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if (invoiceOptional.isPresent()) {
            Invoice existingInvoice = invoiceOptional.get();

            // Update the fields as necessary
            existingInvoice.setClient_name(invoiceDetails.getClient_name());
            existingInvoice.setInvoice_No(invoiceDetails.getInvoice_No());
            existingInvoice.setInvoice_date(invoiceDetails.getInvoice_date());
            existingInvoice.setInvoice_due_date(invoiceDetails.getInvoice_due_date());
            existingInvoice.setPurchase_No(invoiceDetails.getPurchase_No());
            existingInvoice.setPurchase_date(invoiceDetails.getPurchase_date());
            existingInvoice.setPayment_terms(invoiceDetails.getPayment_terms());
            existingInvoice.setTax_selection_on(invoiceDetails.getTax_selection_on());
            existingInvoice.setExport_type(invoiceDetails.getExport_type());
            existingInvoice.setExport_currency(invoiceDetails.getExport_currency());
            existingInvoice.setCountry_supply(invoiceDetails.getCountry_supply());
            existingInvoice.setPlace_supply(invoiceDetails.getPlace_supply());
            existingInvoice.setExcise_duty(invoiceDetails.getExcise_duty());
            existingInvoice.setAdvance_payment(invoiceDetails.getAdvance_payment());
            existingInvoice.setInvoice_type(invoiceDetails.getInvoice_type());
            existingInvoice.setItem_name(invoiceDetails.getItem_name());
            existingInvoice.setItem_description(invoiceDetails.getItem_description());
            existingInvoice.setHsn_sac(invoiceDetails.getHsn_sac());
            existingInvoice.setItem_unit(invoiceDetails.getItem_unit());
            existingInvoice.setItem_quantity(invoiceDetails.getItem_quantity());
            existingInvoice.setItem_price(invoiceDetails.getItem_price());
            existingInvoice.setItem_discount(invoiceDetails.getItem_discount());
            existingInvoice.setTax_cgst_sgst_igst(invoiceDetails.getTax_cgst_sgst_igst());
            existingInvoice.setShipping_charges(invoiceDetails.getShipping_charges());
            existingInvoice.setTotal(invoiceDetails.getTotal());

            // Save the updated invoice
            return invoiceRepository.save(existingInvoice);
        }
        return null; // or throw an exception if invoice not found
    }
    // Delete an invoice
    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }
}
