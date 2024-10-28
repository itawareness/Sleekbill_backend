package com.orage.clientservice.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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

//    public Client saveClient(Client client) {
//    	
//    	
//    	if(client.isUseAsVendor()) {
//    		
//    		
//    	
//    	Vendor v = new Vendor();
//    	v.setCompanyName(client.getCompanyName());
//    	v.setPhone(client.getPhone());
//    	v.setEmail(client.getEmail());
//    	v.setGstTreatment(client.getGstTreatment());
//    	v.setGstin(client.getGstin());
//    	v.setVat(client.getVat());
//    	 return clientRepository.save(client);
//    	}else {
//    		System.out.println("Error coming >>>>>>>>>>>>>>>>>>>>");
//    		 //return clientRepository.save(client);
//    	}
//    	 return clientRepository.save(client);
//    }
//    

//	public Client saveClient(Client client) {
//		// Save the client to the Client table
//		Client savedClient = clientRepository.save(client);
//
//		// If the client should also be treated as a vendor, save to the Vendor table
//		if (client.isUseAsVendor()) {
//			Vendor vendor = new Vendor();
//			vendor.setCompanyName(client.getCompanyName());
//			vendor.setPhone(client.getPhone());
//			vendor.setEmail(client.getEmail());
//			vendor.setGstTreatment(client.getGstTreatment());
//			vendor.setGstin(client.getGstin());
//			vendor.setPan(client.getPan());
//			// vendor.setTin(null);
//			vendor.setVat(client.getVat());
//			vendor.setWebsite(client.getWebsite());
//           
//			vendorRepository.save(vendor);
//		}
//
//		return savedClient;
//	}

	
	
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
        
    
       
	public List<Client> fetchAllClients() {
		return clientRepository.findAll();
	}
}
