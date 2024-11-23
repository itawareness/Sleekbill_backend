package com.orage.clientservice.controller;

import com.orage.clientservice.model.Client;
import com.orage.clientservice.model.Item;
import com.orage.clientservice.service.ClientService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orage.clientservice.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ExcelExportService excelExportService;

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

    @PostMapping("/deleteClients")
    public ResponseEntity<Map<String, String>> deleteClients(@RequestBody List<Long> clientIds) {
        // Your logic for deleting the clients
        clientService.deleteAllById(clientIds);
        // Return a JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Selected clients deleted successfully.");
        return ResponseEntity.ok(response);
    }


    // Export Clients to Excel (Paginated)
    @GetMapping("/exportClients")
    public ResponseEntity<byte[]> exportClientsToExcel(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) throws IOException {

        byte[] excelFile = excelExportService.exportClientsToExcel(page, size);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=clients.xlsx");
        return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
    }


    @GetMapping("/getAllClients")
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientNameById(id).orElseThrow(() -> new RuntimeException("Client not found with id " + id));
        return ResponseEntity.ok(client);
    }

// used for all clients count
    @GetMapping("/allClientCounts")
    public long getClientCount() {
        return clientService.getClientCount();
    }
}
