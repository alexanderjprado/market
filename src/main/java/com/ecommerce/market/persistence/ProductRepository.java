package com.ecommerce.market.persistence;

import com.ecommerce.market.persistence.crud.ProductCrudRepository;
import com.ecommerce.market.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }
}
