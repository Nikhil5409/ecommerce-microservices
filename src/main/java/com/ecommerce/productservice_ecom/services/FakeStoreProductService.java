package com.ecommerce.productservice_ecom.services;

import com.ecommerce.productservice_ecom.models.Product;

import java.util.List;

public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
