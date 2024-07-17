package com.cornbread.nothingismissed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepo = null;

    public List<Item> allItems() {
        return itemRepo.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepo.findById(id)
            .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item saveItem(Item newItem) {
        return itemRepo.save(newItem);
    }

    public Item updateItem(Long id, Item newItem) {
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

    public void deleteItemById(Long id) {
        itemRepo.deleteById(id);
    }
}
