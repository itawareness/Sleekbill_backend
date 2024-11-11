package com.orage.clientservice.service;

import com.orage.clientservice.model.Item;
import com.orage.clientservice.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    // Using constructor injection for better testing and configuration
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Retrieves all items from the database
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    // Saves a new item or updates an existing one in the database
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Retrieves an item by its ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Deletes an item by its ID
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Updates an existing item in the database
    public Item updateItem(Long id, Item itemDetails) {
        Item existingItem = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found with id " + id));

        // Update fields
        existingItem.setName(itemDetails.getName());
        existingItem.setDescription(itemDetails.getDescription());
        existingItem.setSalesUnitPrice(itemDetails.getSalesUnitPrice());
        existingItem.setPurchaseUnitPrice(itemDetails.getPurchaseUnitPrice());
        existingItem.setQuantity(itemDetails.getQuantity());
        existingItem.setUnit(itemDetails.getUnit());
        existingItem.setTax(itemDetails.getTax());
        existingItem.setHsn(itemDetails.getHsn());
        existingItem.setSku(itemDetails.getSku());
        existingItem.setSalesCess(itemDetails.getSalesCess());
        existingItem.setPurchaseCess(itemDetails.getPurchaseCess());
        existingItem.setCurrency(itemDetails.getCurrency());

        return itemRepository.save(existingItem);
    }
}
