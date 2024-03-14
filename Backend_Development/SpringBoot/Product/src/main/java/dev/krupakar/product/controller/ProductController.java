package dev.krupakar.product.controller;

import dev.krupakar.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products")
    public String getAllProducts() {
        return "All products";
    }

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        ProductService productService = new ProductService();
        return productService.getProductById(id);
    }
}
