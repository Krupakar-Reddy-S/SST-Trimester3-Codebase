package com.sst.productservicesst.controllers;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This annotation is used to create a RESTful web service using Spring MVC
@RestController
// localhost:8080/products -> ProductController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
