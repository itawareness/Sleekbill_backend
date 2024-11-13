package com.orage.clientservice.controller;

import com.orage.clientservice.model.Client;
import com.orage.clientservice.service.ClientService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/addClients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.ok(savedClient);
    }




    @GetMapping("/getClients")
    public Page<Client> getClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "") String search) {

        return clientService.getClients(page, size, search);
    }



    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/deleteClients")
//    public ResponseEntity<String> deleteClients(@RequestBody List<Long> clientIds) {
//        try {
//            clientService.deleteAllById(clientIds);
//            return ResponseEntity.ok("Selected clients deleted successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error deleting clients: " + e.getMessage());
//        }
//    }

    @PostMapping("/deleteClients")
    public ResponseEntity<Map<String, String>> deleteClients(@RequestBody List<Long> clientIds) {
        // Your logic for deleting the clients
        clientService.deleteAllById(clientIds);
        // Return a JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Selected clients deleted successfully.");
        return ResponseEntity.ok(response);
    }

}
