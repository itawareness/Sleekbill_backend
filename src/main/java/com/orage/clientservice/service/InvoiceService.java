package com.orage.clientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orage.clientservice.model.Invoice;
import com.orage.clientservice.repository.InvoiceRepository;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
    }

    @Transactional
    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));

        // Map all the necessary fields from invoiceDetails to existingInvoice
        existingInvoice.setClient_name(invoiceDetails.getClientName());
        existingInvoice.setInvoiceNo(invoiceDetails.getInvoiceNo());
        existingInvoice.setInvoiceDate(invoiceDetails.getInvoiceDate());
        existingInvoice.setInvoiceDueDate(invoiceDetails.getInvoiceDueDate());
        existingInvoice.setPurchaseNo(invoiceDetails.getPurchaseNo());
        existingInvoice.setPurchaseDate(invoiceDetails.getPurchaseDate());
        existingInvoice.setPaymentTerms(invoiceDetails.getPaymentTerms());
        existingInvoice.setTaxSelectionOn(invoiceDetails.getTaxSelectionOn());
        existingInvoice.setExportType(invoiceDetails.getExportType());
        existingInvoice.setExportCurrency(invoiceDetails.getExportCurrency());
        existingInvoice.setCountrySupply(invoiceDetails.getCountrySupply());
        existingInvoice.setPlaceSupply(invoiceDetails.getPlaceSupply());
        existingInvoice.setExciseDuty(invoiceDetails.getExciseDuty());
        existingInvoice.setAdvancePayment(invoiceDetails.getAdvancePayment());
        existingInvoice.setInvoiceType(invoiceDetails.getInvoiceType());
        existingInvoice.setItemName(invoiceDetails.getItemName());
        existingInvoice.setItemDescription(invoiceDetails.getItemDescription());
        existingInvoice.setHsnSac(invoiceDetails.getHsnSac());
        existingInvoice.setItemUnit(invoiceDetails.getItemUnit());
        existingInvoice.setItemQuantity(invoiceDetails.getItemQuantity());
        existingInvoice.setItemPrice(invoiceDetails.getItemPrice());
        existingInvoice.setItemDiscount(invoiceDetails.getItemDiscount());
        existingInvoice.setTaxCgstSgstIgst(invoiceDetails.getTaxCgstSgstIgst());
        existingInvoice.setShippingCharges(invoiceDetails.getShippingCharges());
        existingInvoice.setTotal(invoiceDetails.getTotal());

        return invoiceRepository.save(existingInvoice);
    }

    public void deleteInvoice(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new RuntimeException("Invoice not found with id: " + id);
        }
        invoiceRepository.deleteById(id);
    }
}
