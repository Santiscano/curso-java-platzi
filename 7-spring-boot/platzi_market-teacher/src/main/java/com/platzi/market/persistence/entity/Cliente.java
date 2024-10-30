package com.platzi.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente {

    @Getter @Setter
    @Id
    private String id;

    @Getter @Setter
    private String nombre;
    
    @Getter @Setter
    private String apellidos;
    
    @Getter @Setter
    private Long celular;

    @Getter @Setter
    private String direccion;

    @Column(name="correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente") // aqui se mapea con el nombre de la variable en la clase Buyer
    private List<Compra> compras;

}
