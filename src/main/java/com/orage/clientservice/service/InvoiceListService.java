package com.orage.clientservice.service;

import com.orage.clientservice.dto.InvoiceDTO;
import com.orage.clientservice.dto.InvoiceItemDTO;
import com.orage.clientservice.model.Client;
import com.orage.clientservice.model.InvoiceItem;
import com.orage.clientservice.model.Invoices;
import com.orage.clientservice.repository.ClientRepository;
import com.orage.clientservice.repository.InvoiceItemRepository;
import com.orage.clientservice.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class InvoiceListService {

    @Autowired
    private InvoicesRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

//    public Invoices createInvoice(InvoiceDTO invoiceDTO) {
//        Client client = clientRepository.findById(invoiceDTO.getClientId())
//                .orElseThrow(() -> new RuntimeException("Client not found"));
//
//        Invoices invoice = new Invoices();
//        invoice.setInvoiceNo(invoiceDTO.getInvoiceNo());
//        invoice.setPoNo(invoiceDTO.getPoNo());
//        invoice.setPoDate(invoiceDTO.getPoDate());
//        invoice.setPaymentTerms(invoiceDTO.getPaymentTerms());
//        invoice.setTermsAndConditions(invoiceDTO.getTermsAndConditions());
//        invoice.setPrivateNotes(invoiceDTO.getPrivateNotes());
//        invoice.setClient(client);
//
//        // Save Invoice
//        invoice = invoiceRepository.save(invoice);
//
//        // Save Invoice Items
//        for (InvoiceItemDTO itemDTO : invoiceDTO.getItems()) {
//            InvoiceItem item = new InvoiceItem();
//            item.setItemName(itemDTO.getItemName());
//            item.setDescription(itemDTO.getDescription());
//            item.setHsnSac(itemDTO.getHsnSac());
//            item.setQuantity(itemDTO.getQuantity());
//            item.setPrice(itemDTO.getPrice());
//            item.setDiscount(itemDTO.getDiscount());
//            item.setGst(itemDTO.getGst());
//            item.setTotal(itemDTO.getTotal());
//            item.setInvoice(invoice);
//
//            invoiceItemRepository.save(item);
//        }
//
//        return invoice;
//    }



    public Invoices createInvoice(InvoiceDTO invoiceDTO) {
        if (invoiceDTO.getClientId() == null) {
            throw new IllegalArgumentException("Client ID must not be null"); // Throwing a more specific exception
        }

        Client client = clientRepository.findById(invoiceDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Invoices invoice = new Invoices();
        invoice.setInvoiceNo(invoiceDTO.getInvoiceNo());
        invoice.setPoNo(invoiceDTO.getPoNo());
        invoice.setPoDate(invoiceDTO.getPoDate());
        invoice.setPaymentTerms(invoiceDTO.getPaymentTerms());
        invoice.setTermsAndConditions(invoiceDTO.getTermsAndConditions());
        invoice.setPrivateNotes(invoiceDTO.getPrivateNotes());
        invoice.setClient(client);

        // Save Invoice
        invoice = invoiceRepository.save(invoice);

        // Save Invoice Items
        for (InvoiceItemDTO itemDTO : invoiceDTO.getItems()) {
            InvoiceItem item = new InvoiceItem();
            item.setItemName(itemDTO.getItemName());
            item.setDescription(itemDTO.getDescription());
            item.setHsnSac(itemDTO.getHsnSac());
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(itemDTO.getPrice());
            item.setDiscount(itemDTO.getDiscount());
            item.setGst(itemDTO.getGst());
            item.setTotal(itemDTO.getTotal());
            item.setInvoice(invoice);

            invoiceItemRepository.save(item);
        }

        return invoice;
    }

}
