package com.example.technikum.utility;

import com.example.technikum.model.Product;
import com.example.technikum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHelper {

    @Autowired
    ProductRepository productRepository;

    public Long findLastId() {
        List<Product> products = productRepository.findAll();
        Long id = 0L;

        for (Product product : products) {
            decideCurrentId(product, id);
        }

        return products.size() == 0 ? 1L : id;
    }

    public static Long decideCurrentId(Product product, Long id) {
        if(product.getProductId() > id) {
            id = product.getProductId();
        }
        return id;
    }
}
