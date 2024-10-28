package com.orage.clientservice.controller;

import com.orage.clientservice.model.Vendor;
import com.orage.clientservice.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.saveVendor(vendor);

        // Build the URI of the newly created resource and return 201
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVendor.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedVendor);
    }
    
    
    @GetMapping
    public ResponseEntity<List<Vendor>> fetchVendors(){   	
    	List<Vendor> fetchAllVendors = vendorService.fetchAllVendors();
    	return ResponseEntity.ok(fetchAllVendors);
    }
}
