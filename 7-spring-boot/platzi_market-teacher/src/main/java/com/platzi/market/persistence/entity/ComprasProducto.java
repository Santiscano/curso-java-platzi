package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @Getter @Setter
    @EmbeddedId // se utiliza cuando la llave primaria es compuesta y esta dada por la clase ComprasProductoPK
    private ComprasProductoPK id;

    @Getter @Setter
    private Integer cantidad;
    
    @Getter @Setter
    private Double total;
    
    @Getter @Setter
    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    // en vez de utilizar el embeddable, se pudo haber utilizado @JoinColumn y @ManyToOne, ejemplo:
    // @ManyToOne
    // @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    // private Buyer buyer;

    // @ManyToOne
    // @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    // private Product product;
}
