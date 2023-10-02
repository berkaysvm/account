package com.berkay.account.service;

import com.berkay.account.model.Customer;
import com.berkay.account.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id)
    {
        return customerRepository.findById(id).orElseThrow();
    }

}
