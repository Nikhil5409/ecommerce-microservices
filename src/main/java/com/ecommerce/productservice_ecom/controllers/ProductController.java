package com.ecommerce.productservice_ecom.controllers;

import com.ecommerce.productservice_ecom.dtos.ProductNotFoundExceptionDto;
import com.ecommerce.productservice_ecom.exceptions.ProductNotFoundException;
import com.ecommerce.productservice_ecom.models.Product;
import com.ecommerce.productservice_ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        if(productId<1){
            throw new IllegalArgumentException("Product id should be greater than 0");
        }
        Product product = productService.getProductById (productId);

        if(product==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    // Getting all products
    @GetMapping("")
    public List<Product> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }

    /* // These lines are no longer required coz we have implemented global exception handler in controlleradvices package
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage(e.getMessage());
        dto.setProductId(e.getProductId());

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    */

}
