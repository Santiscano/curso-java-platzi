package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.PizzaEntity;
import com.platzi.pizza.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice(); // trae todas las pizzas disponibles ordenadas por precio
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name); // trae la primera pizza disponible que coincida con el nombre
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description); // trae todas las pizzas disponibles que contengan la descripcion
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description); // trae todas las pizzas disponibles que no contengan la descripcion
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price); // trae las 3 pizzas disponibles que tengan un precio menor o igual al precio dado, ordenadas por precio ascendente
    int countByVeganTrue(); // cuenta cuantas pizzas son veganas

    @Query(value =
            "UPDATE pizza " +
            "SET price = :#{#newPizzaPrice.newPrice} " +
            "WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);
}
