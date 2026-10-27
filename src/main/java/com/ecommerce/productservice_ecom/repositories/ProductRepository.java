package com.ecommerce.productservice_ecom.repositories;

import com.ecommerce.productservice_ecom.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Optional<Product> findById(Long id);
}




/*
if we are not using JPA, then we should be writing SQL queries manually to get Data,
getProductById(id) -> select * from products p where p.id = id;
 */
