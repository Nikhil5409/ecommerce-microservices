package com.ecommerce.productservice_ecom.services;

import com.ecommerce.productservice_ecom.dtos.FakeStoreProductDto;
import com.ecommerce.productservice_ecom.exceptions.ProductNotFoundException;
import com.ecommerce.productservice_ecom.models.Category;
import com.ecommerce.productservice_ecom.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        // Implementing a FakeStore APT
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class
                );
        // now, we have to convert FakeStoreDto to product object
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException(id,"Product not found please pass valid product id");
        }
        Product product = from(fakeStoreProductDto);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/" , FakeStoreProductDto[].class
                );
        // now, we have to convert FakeStoreDto[] array into List<>
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : responseEntity.getBody()){
            products.add(from(fakeStoreProductDto));
        }
        return products;
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

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        if(fakeStoreProductDto!=null){
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setImageUrl(fakeStoreProductDto.getImage());

            Category category = new Category();
            category.setTitle(fakeStoreProductDto.getCategory());
            product.setCategory(category);

            return product;
        }
        return null;
    }
}
