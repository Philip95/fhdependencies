package com.example.technikum.service;

import com.example.technikum.enums.CustomerStatus;
import com.example.technikum.model.Customer;
import com.example.technikum.repository.CustomerRepository;
import com.example.technikum.utility.Helper;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    Helper customerHelper;

    public List<Customer> getCustomerInformation() {
        return customerRepository.findAll();
    }

    public void insertRandomCustomers() {
        Faker faker = new Faker();

        for (int i = 0; i <= 100; i++) {
            customerRepository.save(Customer.builder()
                    .id(customerHelper.findLastId())
                    .firstname(faker.name().firstName())
                    .lastname(faker.name().lastName())
                    .address(faker.address().fullAddress())
                    .dateOfBirth((faker.date().birthday(18,60)).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                    .email(faker.internet().emailAddress())
                    .status(CustomerStatus.getRandom().label)
                    .build()
            );
        }
    }

}
