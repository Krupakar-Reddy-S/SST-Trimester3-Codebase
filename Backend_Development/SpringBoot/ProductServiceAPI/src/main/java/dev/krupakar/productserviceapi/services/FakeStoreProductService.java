package dev.krupakar.productserviceapi.services;

import dev.krupakar.productserviceapi.models.Product;

import dev.krupakar.productserviceapi.dtos.FakeStoreProductDto;
import dev.krupakar.productserviceapi.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate = new RestTemplate();
    // Allows to send API requests to any URL

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {

        FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject(
            "https://fakestoreapi.com/products/" + id,
            FakeStoreProductDto.class
        );

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}