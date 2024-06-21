package com.example.demo;

class ItemNotFoundException extends RuntimeException {

    ItemNotFoundException(Long id) {
        super("Could not find item with id: " + id);
    }

}
