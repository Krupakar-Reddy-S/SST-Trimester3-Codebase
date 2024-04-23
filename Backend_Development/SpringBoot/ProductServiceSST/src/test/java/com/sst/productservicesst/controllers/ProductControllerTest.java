package com.sst.productservicesst.controllers;

import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    // What to Test?
    // Happy test case, negative test case, edge test case

    @Autowired // Dependency/Field Injection
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testValidProductId() {
        // Sample Product
        Product product = new Product();
        product.setId(1L);
        product.setTitle("samsung S24");
        product.setPrice(200000.0);

        System.out.println(product.getImageUrl());

        // Mock the ProductService call
        when(productService.getProductById(1L))
                .thenReturn(product);   // Stubbing

        // this call will be intercepted by the mock and return the stubbed value
        Product outputProduct = productController.getProductById(1L);

        System.out.println(product.getImageUrl());
        System.out.println(outputProduct.getImageUrl());

        assertEquals(product, outputProduct, "Product is not same");
    }

    @Test
    void testInvalidProductId() {

    }

    @Test
    void getAllProducts() {
    }

    @Test
    void createProduct() {
    }

}