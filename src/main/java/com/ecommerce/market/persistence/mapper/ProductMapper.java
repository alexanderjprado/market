package com.ecommerce.market.persistence.mapper;

import com.ecommerce.market.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(com.ecommerce.market.persistence.entity.Product product);

    List<Product> toProducts(List<com.ecommerce.market.persistence.entity.Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    com.ecommerce.market.persistence.entity.Product toProduct(Product product);
}
