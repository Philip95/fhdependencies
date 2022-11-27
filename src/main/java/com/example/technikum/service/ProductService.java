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
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .interestRate(BigDecimal.valueOf(faker.number().randomDouble(2, -5, 5)))
                .customer(searchForCustomer(faker))
                .build()
        );
    }

    private Customer searchForCustomer(Faker faker) {
        return customerRepository.findById(faker.number().numberBetween(1l, 100l)).get();
    }

    public Map<String, BigDecimal> averageBalancePerCustomer() {
        List<Long> ids = customerRepository.findAll().stream().map(Customer::getCustomerId).collect(Collectors.toList());
        Map<String, BigDecimal> resultMap = new HashMap<>();
        for (long id : ids) {
            Customer customer = customerRepository.findById(id).get();
            resultMap.put(customer.getFirstname() + ", " + customer.getLastname(), calculateBalance(createBalanceList(id)));
        }
        return resultMap;
    }

    private BigDecimal calculateBalance(List<BigDecimal> balanceList) {
        return (balanceList.size() > 0) ?
                (balanceList.stream()
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                        .divide(new BigDecimal(balanceList.size()), 2, RoundingMode.HALF_DOWN)
                : new BigDecimal(0);
    }

    private List<BigDecimal> createBalanceList(long id) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getCustomer().getCustomerId() == id)
                .map(Product::getBalance)
                .collect(Collectors.toList());
    }
}
