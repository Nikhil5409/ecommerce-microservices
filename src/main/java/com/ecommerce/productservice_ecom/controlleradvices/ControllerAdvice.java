package com.ecommerce.productservice_ecom.controlleradvices;

import com.ecommerce.productservice_ecom.dtos.ProductNotFoundExceptionDto;
import com.ecommerce.productservice_ecom.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage(e.getMessage());
        dto.setProductId(e.getProductId());

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
