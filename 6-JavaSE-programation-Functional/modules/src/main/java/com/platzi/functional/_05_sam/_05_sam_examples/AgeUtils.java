package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {
    public static void main(String[] args) {
        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        // Recibe 3 parametros Integer y retornara un LocalDate
        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
            (day, month, year) -> LocalDate.parse(
                year + "-" +
                addCeros.apply(month) + "-" + 
                addCeros.apply(day)
            );

        // Recibe 3 parametros Integer y retorna Integer
        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
            (day, month, year) -> Period.between(
                parseDate.apply(day, month, year), LocalDate.now() // parseDate.apply es la funcion creada arriba
            ).getYears();

        System.out.println(calculateAge.apply(10, 10, 1992)); // ejecuta calculateAge con el apply definido en la interface
    }

   @FunctionalInterface // interface para generar SAM
   interface TriFunction<T, U, V, R> { // se crea una interface que recibe 4 parametros
        R apply(T t, U u, V v); // se crea un unico metodo apply y se define que debe retornar R y recibira 3 parametros T,U,V
    }
}
