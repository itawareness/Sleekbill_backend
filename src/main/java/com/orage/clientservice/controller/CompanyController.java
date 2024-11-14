package com.orage.clientservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orage.clientservice.dto.CompanyDTO;
import com.orage.clientservice.service.CompanyService;

@RestController
@RequestMapping("/profiles")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

   //  Endpoint to save a new company profile
//    @PostMapping("/save")
//    public ResponseEntity<String> saveCompany(@RequestBody CompanyDTO companyDTO) {
//        try {
//            companyService.saveCompany(companyDTO);
//            return ResponseEntity.ok("Profile saved successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while saving the profile.");
//        }
//    }
    
    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveCompany(@RequestBody CompanyDTO companyDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            companyService.saveCompany(companyDTO);
            response.put("message", "Profile saved successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "An error occurred while saving the profile.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
