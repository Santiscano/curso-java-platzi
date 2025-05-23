package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.OrderEntity;
import com.platzi.pizza.persitence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByDateAfter(LocalDateTime date); // trae todas las ordenes que sean posteriores a la fecha dada
    List<OrderEntity> findAllByMethodIn(List<String> methods); // trae todas las ordenes que tengan un metodo de pago en la lista dada

    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true) // trae todas las ordenes de un cliente
    List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);

    @Query(value =
            "SELECT  po.id_order AS idOrder, cu.name AS customerName, po.date AS orderDate," +
            "        po.total AS orderTotal, GROUP_CONCAT(pi.name) AS pizzaNames " +
            "FROM   pizza_order po  " +
            "   INNER JOIN customer cu ON po.id_customer = cu.id_customer  " +
            "   INNER JOIN order_item oi ON po.id_order = oi.id_order  " +
            "   INNER JOIN pizza pi ON oi.id_pizza = pi.id_pizza  " +
            "WHERE  po.id_order = :orderId " +
            "GROUP BY po.id_order, cu.name, po.date, po.total", nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") int orderId);

    @Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method);
}
