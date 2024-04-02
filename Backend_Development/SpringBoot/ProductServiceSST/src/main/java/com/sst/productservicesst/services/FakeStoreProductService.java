package com.sst.productservicesst.services;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        // convert FakeStoreProductDto to Product
        return FakeStroeProductMapping(fakeStoreProductDto);
    }

    private Product FakeStroeProductMapping(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());

        return product;
    }
}
