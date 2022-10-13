package com.ecommerce.market.persistence;

import com.ecommerce.market.domain.Product;
import com.ecommerce.market.domain.repository.IProductRepository;
import com.ecommerce.market.persistence.entity.crud.IProductoCrudRepository;
import com.ecommerce.market.persistence.entity.Producto;
import com.ecommerce.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements IProductRepository {
    @Autowired
    private IProductoCrudRepository iProductoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    //Para obtener todos los productos que tenga en mi supermercado
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) iProductoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // Obtenemos una lista de productos que pertenecen a una categoría, ordenados en orden alfabetico
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = iProductoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = iProductoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    // Obtenemos un producto dado su id
    @Override
    public Optional<Product> getProduct(int productId) {
        return iProductoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    //Guardar un producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProduct(product);
        return mapper.toProduct(iProductoCrudRepository.save(producto));
    }

    //Borrar un producto
    public void delete(int idProducto) {
        iProductoCrudRepository.deleteById(idProducto);
    }
}