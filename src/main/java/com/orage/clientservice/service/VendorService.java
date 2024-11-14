package com.orage.clientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orage.clientservice.model.Client;
import com.orage.clientservice.model.Vendor;
import com.orage.clientservice.repository.ClientRepository;
import com.orage.clientservice.repository.VendorRepository;

@Service
public class VendorService {

    public Vendor saveVendor(Vendor vendor) {
        // Save the vendor to the Vendor table
        Vendor savedVendor = vendorRepository.save(vendor);

        // If the vendor should also be treated as a client, save to the Client table
        if (vendor.isUseAsClient()) {
            Client client = new Client();
            mapVendorToClient(vendor, client);
            clientRepository.save(client);
        }

        return savedVendor;
    }

    }
}
