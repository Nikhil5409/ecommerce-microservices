package com.ecommerce.productservice_ecom.services;

import com.ecommerce.productservice_ecom.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
