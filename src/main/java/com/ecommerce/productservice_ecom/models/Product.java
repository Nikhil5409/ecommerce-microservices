package com.ecommerce.productservice_ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private int qty;
    @ManyToOne
    private Category category;
    // product - category is M:1 relation
}
