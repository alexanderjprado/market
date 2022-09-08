package com.ecommerce.market.persistence;

import com.ecommerce.market.persistence.crud.ProductCrudRepository;
import com.ecommerce.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<Product> getProducto(int idProducto) {
        return productCrudRepository.findById(idProducto);
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void delete(int idProducto) {
        productCrudRepository.deleteById(idProducto);
    }
}
