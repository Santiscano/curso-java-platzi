package com.platzi.pizza.persitence.entity;

import com.platzi.pizza.persitence.audit.AuditPizzaListener;
import com.platzi.pizza.persitence.audit.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity // define que la clase es una entidad.
@Table(name = "pizza") // define el nombre de la tabla en la base de datos.
@EntityListeners({AuditingEntityListener.class, AuditPizzaListener.class}) // define los listeners de la entidad, un listener es una clase que se encarga de escuchar los eventos de la entidad.
// no es buena practica usar el @Data, ya que genera un método equals y hashcode que no son recomendados para entidades.
@Getter // genera los métodos get.
@Setter // genera los métodos set.
@NoArgsConstructor // genera un constructor vacío.
public class PizzaEntity extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "idPizza=" + idPizza +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", available=" + available +
                '}';
    }
}
