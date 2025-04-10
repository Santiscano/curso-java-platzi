package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // source es el nombre de la variable en Categoria y target en Category, y se indica como se van a mapear
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria); // de categoria a category

    @InheritInverseConfiguration // esta anotación permite que se haga la conversión inversa a la del Mapping de arriba
    @Mapping(target = "productos", ignore = true) // en este caso se ignora la variable productos hacia Category
    Categoria toCategoria(Category category);
}
