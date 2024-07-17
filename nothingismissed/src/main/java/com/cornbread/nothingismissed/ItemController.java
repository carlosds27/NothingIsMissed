package com.cornbread.nothingismissed;

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
    private final ItemService itemServ = null;

    // Get all the items in the database
    @GetMapping("/items")
    public List<Item> allItems() {
        return itemServ.allItems();
    }

    // Save new item to the database
    @PostMapping("/item")
    public Item newItem(@RequestBody Item newItem) {
        return itemServ.saveItem(newItem);
    }
    
    // Get one item in the database
    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemServ.getItemById(id);
    }
    
    // Update one single item in the database
    @PutMapping("/item/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item newItem) {
        return itemServ.updateItem(id, newItem);
    }

    // Delete one item
    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemServ.deleteItemById(id);
    }
}
