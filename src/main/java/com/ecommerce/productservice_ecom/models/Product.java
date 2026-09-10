package com.ecommerce.productservice_ecom.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private int qty;
    private Category category;
}
