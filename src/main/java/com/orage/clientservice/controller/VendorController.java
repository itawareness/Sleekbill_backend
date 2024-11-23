package com.orage.clientservice.controller;

import com.orage.clientservice.model.Vendor;

import com.orage.clientservice.service.VendorExcelExportService;
import com.orage.clientservice.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;


    @Autowired
    private VendorExcelExportService excelExportService;

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




    @PostMapping("/deleteVendors")
    public ResponseEntity<Map<String, String>> deleteVendor(@RequestBody List<Long> vendorIds) {

        vendorService.deleteAllById(vendorIds);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Selected vendors deleted successfully.");
        return ResponseEntity.ok(response);
    }

    // Export Clients to Excel (Paginated)
    @GetMapping("/exportVendors")
    public ResponseEntity<byte[]> exportVendorToExcel(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) throws IOException {

        byte[] excelFile = excelExportService.exportVendorsToExcel(page, size);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=clients.xlsx");
        return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
    }

// used for all clients count
   @GetMapping("/allVendorCounts")
   public long getClientCount() {
       return vendorService.getVendorCount();
    }
}
