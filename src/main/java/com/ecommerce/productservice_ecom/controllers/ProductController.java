package com.ecommerce.productservice_ecom.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    // localhost:8080/products/hello - the above request/url comes to this sayHello() method
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
