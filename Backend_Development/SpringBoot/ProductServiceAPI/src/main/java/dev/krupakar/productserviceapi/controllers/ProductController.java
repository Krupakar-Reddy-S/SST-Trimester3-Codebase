package dev.krupakar.productserviceapi.controllers;

import dev.krupakar.productserviceapi.models.Product;
import dev.krupakar.productserviceapi.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Whenever a GET request is made to {MY_SERVER}/hello, the sayHello method is called
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/sing")
    public String sayShamina() {
        return "Shaminamina eh eh waka waka eh eh";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }


    // URL Path: /products/1
    // /products/hi
    // /products/51
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {

        return productService.getSingleProduct(id);
    }

//    @PostMapping("/products")
//    public Product createProduct(@RequestParam("title") String title,
//                                 @RequestParam("description") String description) {
//        return new Product();
//    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return null;
    }


}
