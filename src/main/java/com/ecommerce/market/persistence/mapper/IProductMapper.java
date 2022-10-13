package com.ecommerce.market.persistence.mapper;

import com.ecommerce.market.domain.Product;
import com.ecommerce.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IProductMapper.class})
public interface IProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productoId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
    })

    Producto toProduct(Producto producto);

    @InheritInverseConfiguration
    @Mapping(target = "categoria", ignore = true)
    Producto toProduct(Product product);
}
