package com.sst.productservicesst.controllers;
import com.sst.productservicesst.dtos.ExceptionDto;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        // throw new RuntimeException("Something went Wrong!");
        // ResponseEntity<Product> responseEntity = null;
        // Product product = null;
        // try{
        //     product = productService.getProductById(id);
        //     responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        //     System.out.println("Hello!");
        //     return responseEntity;
        // } catch (RuntimeException e){
        //     ExceptionDto dto = new ExceptionDto();
        //     dto.setMessage("Something went wrong");
        //     dto.setResolution("Do Nothing");
        //     ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        //     return response;
        // }

        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
