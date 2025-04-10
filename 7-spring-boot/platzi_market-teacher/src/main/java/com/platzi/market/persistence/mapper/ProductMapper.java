package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// uses se usa para indicar que se va a usar otro Mapper, en este caso CategoryMapper ya que es de la clase Category
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    // source es el nombre de la variable en Producto y target en Product, y se indica como se van a mapear
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto); // de Producto a Product
    List<Product> toProducts(List<Producto> productos); // tambien para listas, de List<Producto> a List<Product>

    @InheritInverseConfiguration // esta anotación permite que se haga la conversión inversa a la del Mapping de arriba
    @Mapping(target = "codigoBarras", ignore = true) // en este caso se ignora la variable codigoBarras hacia Product
    Producto toProducto(Product product); // de Product a Producto
}
