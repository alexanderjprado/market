package com.ecommerce.market.persistence;

import com.ecommerce.market.persistence.crud.ProductCrudRepository;
import com.ecommerce.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategoria(int idCategoria) {
        return productCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Product>> getEscasos(int cantidad) {
        return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
