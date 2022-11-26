package com.example.technikum.utility;

import com.example.technikum.model.Customer;
import com.example.technikum.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerHelper {

    @Autowired
    CustomerRepository customerRepository;

    public Long findLastId() {
        List<Customer> customers = customerRepository.findAll();
        Long id = 0L;

        for (Customer customer : customers) {
            decideCurrentId(customer, id);
        }

        return customers.size() == 0 ? 1L : id;
    }

    public static Long decideCurrentId(Customer customer, Long id) {
        if(customer.getCustomerId() > id) {
            id = customer.getCustomerId();
        }
        return id;
    }
}
