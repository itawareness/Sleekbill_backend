package com.orage.clientservice.service;

import java.util.List;
import java.util.Random;

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
public class ClientService {

	@Autowired
	private VendorRepository vendorRepository;

	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	
	 // Method to generate a unique 6-digit vendor code
    private String generateVendorCode() {
        Random random = new Random();
        int vendorCode;
        
        // Keep generating a new code until we find one that is unique
        do {
            vendorCode = 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999
        } while (vendorRepository.existsByVendorCode(String.valueOf(vendorCode))); // Check for uniqueness
        
        return String.valueOf(vendorCode);
    }

    // Add new client
    public Client saveClient(Client client) {
        // Save the client to the Client table
        Client savedClient = clientRepository.save(client);

        // If the client should also be treated as a vendor, save to the Vendor table
        if (client.isUseAsVendor()) {
            Vendor vendor = new Vendor();
            vendor.setCompanyName(client.getCompanyName());
            vendor.setPhone(client.getPhone());
            vendor.setEmail(client.getEmail());
            vendor.setGstTreatment(client.getGstTreatment());
            vendor.setGstin(client.getGstin());
            vendor.setPan(client.getPan());
            // vendor.setTin(null); // Set to null or adjust as needed
            vendor.setVat(client.getVat());
            vendor.setWebsite(client.getWebsite());
            
            // Generate and set the vendor code
            String vendorCode = generateVendorCode();
            vendor.setVendorCode(vendorCode);
        
            vendorRepository.save(vendor);
     
        }
        
        return savedClient;
    }
        



    public Page<Client> getClients(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);

        // If search is provided, filter based on company name
        if (search != null && !search.isEmpty()) {
            return clientRepository.findByCompanyNameContainingIgnoreCase(search, pageable);
        }

        // If no search, return all clients with pagination
        return clientRepository.findAll(pageable);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    // Method to delete all clients by their IDs
    @Transactional
    public void deleteAllById(List<Long> clientIds) {
        // If clientIds is empty, do nothing
        if (clientIds != null && !clientIds.isEmpty()) {
            clientRepository.deleteAllByIdIn(clientIds);
        }
    }


}
