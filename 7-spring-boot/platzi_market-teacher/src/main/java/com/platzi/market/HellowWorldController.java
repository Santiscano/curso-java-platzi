package com.platzi.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // lo convierte en controlador y tambien en devolver un JSON
@RequestMapping("/hello") // maneja todas las solicitudes http (get, post, put, delete) que lleguen a /hello
public class HellowWorldController {

    @GetMapping("/world")
    public String HelloWorld() {
        return "Hello World to Platzi Market - Never Stop Learning!";
    }
}
