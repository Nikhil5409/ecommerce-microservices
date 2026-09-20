package com.ecommerce.productservice_ecom.controllers;

import com.ecommerce.productservice_ecom.models.Product;
import com.ecommerce.productservice_ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //@Autowired   -> we can also inject the dependency using Autowired annotation instead of constructor injection, our wish, but constructor is widely used
    private ProductService productService;
    public ProductController(ProductService productService) {
            this.productService = productService;
    }
    // localhost:8080/products/hello - the above request/url comes to this sayHello() method
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
    // we should add all CRUD operations on Product Model
    // Getting a single product with id
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        Product product = productService.getProductById(productId);
        return product;
    }
    // Getting all products
    @GetMapping("")
    public List<Product> getAllProducts(){
        return null;
    }

}
