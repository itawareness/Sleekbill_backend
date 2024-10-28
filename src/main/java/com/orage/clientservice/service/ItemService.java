package com.orage.clientservice.service;

import com.orage.clientservice.model.Item;
import com.orage.clientservice.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found with id " + id));
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setSalesUnitPrice(itemDetails.getSalesUnitPrice());
        item.setPurchaseUnitPrice(itemDetails.getPurchaseUnitPrice());
        item.setQuantity(itemDetails.getQuantity());
        item.setUnit(itemDetails.getUnit());
        item.setTax(itemDetails.getTax());
        item.setHsn(itemDetails.getHsn());
        item.setSku(itemDetails.getSku());
        item.setSalesCess(itemDetails.getSalesCess());
        item.setPurchaseCess(itemDetails.getPurchaseCess());
        item.setCurrency(itemDetails.getCurrency());
        return itemRepository.save(item);
    }
}
