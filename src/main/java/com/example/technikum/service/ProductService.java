package com.example.technikum.service;

import com.example.technikum.model.Customer;
import com.example.technikum.model.Product;
import com.example.technikum.repository.CustomerRepository;
import com.example.technikum.repository.ProductRepository;
import com.example.technikum.utility.ProductHelper;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ProductHelper productHelper;

    public List<Product> getProductInformation() {
        return productRepository.findAll();
    }

    public void insertRandomProducts() {
        Faker faker = new Faker();

        for (int i = 0; i <= 100; i++) {
            createProduct(faker);
        }
    }

    private void createProduct(Faker faker) {
        productRepository.save(Product.builder()
                .productId(productHelper.findLastId())
                .name(faker.commerce().productName())
                .balance(BigDecimal.valueOf(faker.number().randomDouble(2, -10000, 100000)))
                .productCode(faker.finance().bic())
                .interestRate(BigDecimal.valueOf(faker.number().randomDouble(2, -5,5)))
                .customer(searchforCustomer(faker))
                .build()
        );
    }

    private Customer searchforCustomer(Faker faker) {
        return customerRepository.findById(faker.number().numberBetween(1l, 100l)).get();
    }
}
