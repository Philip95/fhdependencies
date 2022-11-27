package com.example.technikum.controller;

import com.example.technikum.model.Customer;
import com.example.technikum.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customerInformation")
    public List<Customer> getAllCustomerInformation() {
        return customerService.getCustomerInformation();
    }
    @PostMapping("/insertRandomCustomers")
    public void insertRandomCustomers() {
        customerService.insertRandomCustomers();
    }



}
