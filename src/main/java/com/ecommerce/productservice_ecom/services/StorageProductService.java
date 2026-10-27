package com.ecommerce.productservice_ecom.services;

import com.ecommerce.productservice_ecom.exceptions.ProductNotFoundException;
import com.ecommerce.productservice_ecom.models.Product;
import com.ecommerce.productservice_ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class StorageProductService implements ProductService {

    //@Autowired   -> either Autowired or constructor injection we can do for getting repository in service
    private ProductRepository productRepository;
    public StorageProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product input) {
        Optional<Product> productOptional = productRepository.findById(input.getId());
        if(productOptional.isEmpty()) {
            return productRepository.save(input);
        }else{
            return null;
        }
    }

    @Override
    public Product updateProduct(Long productId, Product input) {

        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
