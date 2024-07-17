package com.cornbread.nothingismissed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
class CustomerController {
    @Autowired
    private final CustomerService customerServ = null;

    @GetMapping("/customers")
    public List<Customer> allCustomer() {
        return customerServ.allCustomer();
    }

    @PostMapping("/customer")
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerServ.saveCustomer(newCustomer);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerServ.getCustomerById(id);
    }
    
    @PutMapping("customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer newCustomer) {
        return customerServ.updateCustomer(id, newCustomer);
    }

    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerServ.deleteCustomerById(id);
    }
}
