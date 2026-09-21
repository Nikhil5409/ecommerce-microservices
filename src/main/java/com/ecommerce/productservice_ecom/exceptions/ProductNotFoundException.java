package com.ecommerce.productservice_ecom.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{
    private Long productId;
    private String message;

    public ProductNotFoundException(Long productId,String message) {
        this.message = message;
        this.productId=productId;
    }
}