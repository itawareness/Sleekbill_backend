package com.orage.clientservice.controller;

import com.orage.clientservice.model.Item;
import com.orage.clientservice.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() {
        return itemService.findAllItems();
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedItem.getId()).toUri();
        return ResponseEntity.created(location).body(savedItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id).orElseThrow(() -> new RuntimeException("Item not found with id " + id));
        return ResponseEntity.ok(item);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
//        Item updatedItem = itemService.updateItem(id, itemDetails);
//        return ResponseEntity.ok(updatedItem);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
//        itemService.deleteItem(id);
//        return ResponseEntity.ok("Item deleted successfully");
//    }



}
