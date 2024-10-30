package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity // esta define que esta clase es una entidad de la base de datos
@Table(name = "productos") // esta define el nombre de la tabla en la base de datos
public class Producto {

    @Id  // esta define que es la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // esta define que es autoincrementable
    @Getter @Setter // con esto evito tener que hacer los getter y setter
    @Column(name = "id_producto")  // esta define el nombre de la columna en la base de datos
    private Integer idProducto;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Getter @Setter
    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Getter @Setter
    @Column(name = "precio_venta")
    private Double precioVenta;

    @Getter @Setter
    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    @Getter @Setter
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) // insertable y updatable son para que no se inserte ni se actualice
    @Getter @Setter
    private Categoria categoria; // esta es la relación con la tabla categorias, solo sirve para que en las consultas se pueda traer la información de la categoría

    @OneToMany(mappedBy = "product")
    private List<BuyerProducts> buyers;
}
