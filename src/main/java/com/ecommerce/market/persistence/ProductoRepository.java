package com.ecommerce.market.persistence;

import com.ecommerce.market.persistence.crud.IProductoCrudRepository;
import com.ecommerce.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private IProductoCrudRepository iProductoCrudRepository;

    //Para obtener todos los productos que tenga en mi supermercado
    public List<Producto> getAll() {
        return (List<Producto>) iProductoCrudRepository.findAll();
    }
    // Obtenemos una lista de productos que pertenecen a una categoría, ordenados en orden alfabetico
    public List<Producto> getByCategoria(int idCategoria) {
        return iProductoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return iProductoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    // Obtenemos un producto dado su id
    public Optional<Producto> getProducto(int idProducto) {
        return iProductoCrudRepository.findById(idProducto);
    }

    //Guardar un producto
    public Producto save(Producto producto) {
        return iProductoCrudRepository.save(producto);
    }

    //Borrar un producto
    public void delete(int idProducto) {
        iProductoCrudRepository.deleteById(idProducto);
    }
}
