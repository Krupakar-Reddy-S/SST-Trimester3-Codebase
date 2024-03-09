package dev.krupakar.productserviceapi.services;

import dev.krupakar.productserviceapi.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    Product createProduct(Product product);
}
