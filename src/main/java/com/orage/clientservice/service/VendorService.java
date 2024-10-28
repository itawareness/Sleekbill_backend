package com.orage.clientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orage.clientservice.model.Client;
import com.orage.clientservice.model.Vendor;
import com.orage.clientservice.repository.ClientRepository;
import com.orage.clientservice.repository.VendorRepository;

@Service
public class VendorService {
	
    @Autowired
    private ClientRepository clientRepository;
    
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

//    public Vendor saveVendor(Vendor vendor) {
//        return vendorRepository.save(vendor);
//    }
    

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
    
    
    
    
    
    
    public List<Vendor> fetchAllVendors()
    {
    	return vendorRepository.findAll();
    }
}
