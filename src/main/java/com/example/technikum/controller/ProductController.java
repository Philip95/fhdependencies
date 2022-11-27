package com.example.technikum.controller;

import com.example.technikum.model.Product;
import com.example.technikum.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/productInformation")
    public List<Product> getAllProductInformation() {
        return productService.getProductInformation();
    }

    @PostMapping("/insertRandomProducts")
    public void insertRandomCustomers() {
        productService.insertRandomProducts();
    }

    @GetMapping("/groupBy")
    public Map<String, BigDecimal> getGroupByResult() {
        return productService.averageBalancePerCustomer();
    }
}
