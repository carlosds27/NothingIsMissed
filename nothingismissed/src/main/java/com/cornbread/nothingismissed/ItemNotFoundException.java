package com.cornbread.nothingismissed;

class ItemNotFoundException extends RuntimeException {

    ItemNotFoundException(Long id) {
        super("Could not find item with id: " + id);
    }

}

