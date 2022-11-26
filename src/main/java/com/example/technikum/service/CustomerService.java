package com.example.technikum.service;

import com.example.technikum.model.Customer;
import com.example.technikum.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public List<Customer> getCustomerInformation() {
        return customerRepository.findAll();
    }

}
