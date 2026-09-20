package com.ecommerce.productservice_ecom.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

// in the DTO, we have to specify what all attributes we want from FakeStore api, what all are required for us
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;
}
