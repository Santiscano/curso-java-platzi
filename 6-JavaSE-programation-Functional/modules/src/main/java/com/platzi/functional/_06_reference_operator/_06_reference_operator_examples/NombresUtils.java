package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {
    public static void main(String[] args) {
        List<String> profesores = getList("Nicolas", "Juan", "Zulema");

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);
        System.out.println("//////////");
        profesores.forEach(System.out::println);
    }

    /*
     * @Param <T> define un tipo generico
     * @Return List<T> devuelve una lista de tipo generico
     * @Param T... elements recibe un numero indefinido de elementos tipo <T>
     * @Return Arrays.asList(elements) devuelve una lista de tipo <T> con los elementos recibido por argumento
     */
    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }
}
