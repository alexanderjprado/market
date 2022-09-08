package com.ecommerce.market.persistence.mapper;

import com.ecommerce.market.domain.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    com.ecommerce.market.persistence.entity.Category toCategoria(Category category);
}
