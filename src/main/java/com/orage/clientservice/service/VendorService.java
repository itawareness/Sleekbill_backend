package com.orage.clientservice.service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.orage.clientservice.model.Client;
import com.orage.clientservice.model.Vendor;
import com.orage.clientservice.repository.ClientRepository;
import com.orage.clientservice.repository.VendorRepository;

@Service
public class VendorService {
	
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private  VendorRepository vendorRepository;



    // Add new vendor
    public Vendor saveVendor(Vendor vendor) {
        // Save the vendor to the Vendor table
        Vendor savedVendor = vendorRepository.save(vendor);

        // If the vendor should also be treated as a client, save to the Client table
        if (vendor.isUseAsClient()) {
            Client client = new Client();
            client.setCompanyName(vendor.getCompanyName());
            client.setPhone(vendor.getPhone());
            client.setEmail(vendor.getEmail());
            client.setGstTreatment(vendor.getGstTreatment());
            client.setGstin(vendor.getGstin());
            client.setPan(vendor.getPan());
            client.setVat(vendor.getVat());
            client.setWebsite(vendor.getWebsite());
            client.setUseAsVendor(true); // Indicating this client can also act as a vendor

            // Save the client to the Client table
            clientRepository.save(client);
        }

        return savedVendor;
    }
    
    

    public Page<Vendor> getVendors(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);

        if (search != null || !search.isEmpty()) {
            return vendorRepository.findByCompanyNameContainingIgnoreCase(search, pageable);

        }
            return vendorRepository.findAll(pageable); // If no search, return all vendors with pagination

    }

    // Method to delete all clients by their IDs
    @Transactional
    public void deleteAllById(List<Long> vendorIds) {
        // If clientIds is empty, do nothing
        if (vendorIds != null && !vendorIds.isEmpty()) {
            vendorRepository.deleteAllByIdIn(vendorIds);
        }
    }
}
