package dev.krupakar.productserviceapi;

import dev.krupakar.productserviceapi.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApiApplication.class, args);

//        Product product = new Product();
//        product.setId(1L); // Auto generated getters and setters with Lombok
    }

}
