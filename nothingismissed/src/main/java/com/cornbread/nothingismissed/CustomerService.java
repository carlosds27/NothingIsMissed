package com.cornbread.nothingismissed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepo = null;

    public List<Customer> allCustomer() {
        return customerRepo.findAll();
    }

    public Customer saveCustomer(Customer newCustomer) {
        return customerRepo.save(newCustomer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));
    }
    
    public Customer updateCustomer(Long id, Customer newCustomer) {
        return customerRepo.findById(id)
            .map(item -> {
                item.setName(newCustomer.getName());
                item.setAddress(newCustomer.getAddress());
                item.setPhoneNumber(newCustomer.getPhoneNumber());
                item.setBalance(newCustomer.getBalance());
                return customerRepo.save(item);
            })
            .orElseGet(() -> {
                return customerRepo.save(newCustomer);
            });
    }

    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }
}
