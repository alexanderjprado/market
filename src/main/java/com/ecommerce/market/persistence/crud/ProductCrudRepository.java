package com.ecommerce.market.persistence.crud;

import com.ecommerce.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

}
