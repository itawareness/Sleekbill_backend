package com.orage.clientservice.controller;

import com.orage.clientservice.model.Vendor;
import com.orage.clientservice.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/addVendor")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.saveVendor(vendor);

        // Build the URI of the newly created resource and return 201
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVendor.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedVendor);
    }
    


    @GetMapping("/getVendors")
    public Page<Vendor> getVendors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "") String search) {

        return vendorService.getVendors(page, size, search);
    }
}
