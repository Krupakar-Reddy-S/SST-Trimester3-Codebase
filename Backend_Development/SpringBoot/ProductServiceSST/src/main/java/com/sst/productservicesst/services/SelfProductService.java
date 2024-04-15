package com.sst.productservicesst.services;

import com.sst.productservicesst.exceptions.CategoryNotFoundException;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.repositories.CategoryRepository;
import com.sst.productservicesst.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
// @Primary
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductNotFoundException(id, "Product with id " + id + " not found!");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException(category.getId(), "Invalid Category Id passed!");
        }

        product1.setCategory(optionalCategory.get());

        return product1;
    }
}
