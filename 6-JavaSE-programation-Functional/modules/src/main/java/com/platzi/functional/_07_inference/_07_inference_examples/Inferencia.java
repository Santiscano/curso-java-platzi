package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {
    public static void main(String[] args) {
        Function<Integer, String> funcionConvertidora = x -> "Al doble:" + (x * 2) ;

        List<String> alumnos = NombresUtils.getList("Hugo", "Paco", "Luis"); // generamos una lista de alumnos
        alumnos.forEach((String name) -> System.out.println(name)); // Tipo declarado explícitamente String name
        alumnos.forEach(name -> System.out.println(name)); // ✅ Java infirió que name es String
        alumnos.forEach(System.out::println); // ✅ Usa referencia a método aún más compacta
    }
}
