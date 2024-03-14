package dev.krupakar.product.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public String getProductById(Long id) {
        return "Product by id: " + id;
    }
}
