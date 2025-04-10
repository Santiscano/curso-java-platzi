package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // define que esta clase es un controlador
@RequestMapping("/products") // define la ruta base de la clase para acceder a los metodos
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/") // define que es un metodo get y la ruta, en este caso la raiz
    @ApiOperation("Get all supermarket products") // documentacion de la api
    @ApiResponse(code = 200, message = "OK") // documentacion de la api
    // ResponseEntity es una clase de spring que permite devolver una respuesta http
    public ResponseEntity<List<Product>> getAll() {
        // responseEntity recibe como primer parametro el cuerpo de la respuesta y como segundo estado de la respuesta
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID") // para documentacion
    @ApiResponses({ // para documentacion
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7")
                                                @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                // este map no es el mismo que el de java, este map es de optional que lo que hace es que si el optional tiene un valor lo devuelve, si no devuelve un optional vacio
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
                // orElse es un metodo de optional que se ejecuta si el optional esta vacio
        // nueva opcion
        return ResponseEntity.of(productService.getProduct(productId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
