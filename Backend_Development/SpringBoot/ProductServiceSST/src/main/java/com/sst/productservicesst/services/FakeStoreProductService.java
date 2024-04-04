package com.sst.productservicesst.services;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sst.productservicesst.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(Long id) {
        // throw new RuntimeException("Something went Wrong in Service!");
        // int x = 1/0; // to trigger Arithmetic Exception Handler
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Please pass a valid productId");
        }

        // convert FakeStoreProductDto to Product
        return FakeStoreProductMapping(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(FakeStoreProductMapping(fakeStoreProductDto));
        }

        return products;
    }

    private Product FakeStoreProductMapping(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());

        Category category = new Category();
        category.setId(null);
        category.setTitle(null);
        category.setDescription(fakeStoreProductDto.getCategory());

        product.setCategory(category);

        return product;
    }
}
