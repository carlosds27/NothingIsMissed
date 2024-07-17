package com.cornbread.nothingismissed;

class CustomerNotFoundException extends RuntimeException{

    CustomerNotFoundException(Long id) {
        super("Could not find customer with id: " + id);
    }
}
