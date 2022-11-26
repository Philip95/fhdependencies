package com.example.technikum.service;

import com.example.technikum.enums.CustomerStatus;
import com.example.technikum.model.Customer;
import com.example.technikum.model.Product;
import com.example.technikum.repository.ProductRepository;
import com.example.technikum.utility.Helper;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZoneId;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    Helper helper;

    public List<Product> getProductInformation() {
        return productRepository.findAll();
    }

    public void insertRandomProducts() {
        Faker faker = new Faker();

        for (int i = 0; i <= 100; i++) {
            productRepository.save(Product.builder()
                    .id(helper.findLastId())
                    .name(faker.commerce().productName())
                    .balance(BigDecimal.valueOf(faker.number().randomDouble(2, -10000, 100000)))
                    .productCode(faker.finance().bic())
                    .interestRate(BigDecimal.valueOf(faker.number().randomDouble(2, -5,5)))
                    .build()
            );
        }
    }
}
