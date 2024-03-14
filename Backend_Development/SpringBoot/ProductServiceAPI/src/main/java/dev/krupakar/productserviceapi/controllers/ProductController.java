package dev.krupakar.productserviceapi.controllers;

import dev.krupakar.productserviceapi.models.Product;
import dev.krupakar.productserviceapi.services.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return productService.getCategories();
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}