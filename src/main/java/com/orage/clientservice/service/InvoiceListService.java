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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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


    public Invoices createInvoice(Invoices invoiceDTO) {
        // Validate the client ID
        if (invoiceDTO.getClient() == null || invoiceDTO.getClient().getId() == null) {
            throw new RuntimeException("Client ID must be provided.");
        }

        // Fetch the client from the database
        Client client = clientRepository.findById(invoiceDTO.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found."));

        // Create and populate the invoice object
        Invoices invoice = new Invoices();
        invoice.setClient(client);
        invoice.setInvoiceNo(invoiceDTO.getInvoiceNo());
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setDueDate(invoiceDTO.getDueDate());
        invoice.setPoNo(invoiceDTO.getPoNo());
        invoice.setPoDate(invoiceDTO.getPoDate());
        invoice.setPaymentTerms(invoiceDTO.getPaymentTerms());
        invoice.setTermsAndConditions(invoiceDTO.getTermsAndConditions());
        invoice.setPrivateNotes(invoiceDTO.getPrivateNotes());

        // Add items to the invoice and set up the relationship
        List<InvoiceItem> items = new ArrayList<>();
        for (InvoiceItem itemDTO : invoiceDTO.getItemList()) {
            InvoiceItem item = new InvoiceItem();
            item.setItemName(itemDTO.getItemName());
            item.setDescription(itemDTO.getDescription());
            item.setHsnSac(itemDTO.getHsnSac());
            item.setItemQuantity(itemDTO.getItemQuantity());
            item.setItemPrice(itemDTO.getItemPrice());
            item.setItemDiscount(itemDTO.getItemDiscount());
            item.setItemGst(itemDTO.getItemGst());
            item.setTotal(itemDTO.getTotal());
            item.setInvoice(invoice); // Link each item to the parent invoice
            items.add(item);
        }

        invoice.setItemList(items); // Set all items in the invoice

        // Save the invoice (cascades the items due to CascadeType.ALL)
        return invoiceRepository.save(invoice);
    }
}
