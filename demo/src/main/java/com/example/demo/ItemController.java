package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ItemController { 
    @Autowired
    private final ItemRepository itemRepo = null;

    // Get all the items in the database
    @GetMapping("/items")
    List<Item> allItems() {
        return itemRepo.findAll();
    }

    // Save new item to the database
    @PostMapping("/item")
    Item newItem(@RequestBody Item newItem) {
        return itemRepo.save(newItem);
    }
    
    // Get one item in the database
    @GetMapping("/item/{id}")
    Item getItem(@PathVariable Long id) {
        return itemRepo.findById(id)
            .orElseThrow(() -> new ItemNotFoundException(id));
    }
    
    // Update one single item in the database
    @PutMapping("/item/{id}")
    Item updateItem(@PathVariable Long id, @RequestBody Item newItem) {
        return itemRepo.findById(id)
            .map(item -> {
                item.setProductName(newItem.getProductName());
                item.setPrice(newItem.getPrice());
                item.setAmount(newItem.getAmount());
                return itemRepo.save(item);
            })
            .orElseGet(() -> {
                return itemRepo.save(newItem);
            });
    }

    // Delete one item
    @DeleteMapping("/item/{id}")
    void deleteItem(@PathVariable Long id) {
        itemRepo.deleteById(id);
    }
}
