package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = // primera forma de definir una funcion
                new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer x) {
                        return x * x;
                    }
                };
        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(25));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1; // anotacion mas corta de funciones

        Predicate<Integer> isEven = x -> x % 2 == 0; // Predicate es una interfaz funcional que recibe un argumento y devuelve un booleano
        isEven.test(4); //true -> asi se invoca

        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;

        Student sinuhe = new Student(5.9);
        System.out.println(isApproved.test(sinuhe));
    }

    static class Student {
        private double calificacion;

        public Student(double calificacion){
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }
    }
}
