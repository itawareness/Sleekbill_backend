package com.orage.clientservice.controller;

import com.orage.clientservice.model.Client;
import com.orage.clientservice.service.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.ok(savedClient);



    }
    
    
    @GetMapping
     public ResponseEntity<List<Client>> fetchClients(){  	
    	List<Client> fetchAllClients = clientService.fetchAllClients();   	
    	return ResponseEntity.ok(fetchAllClients);
    	
    	
    }
    
}
