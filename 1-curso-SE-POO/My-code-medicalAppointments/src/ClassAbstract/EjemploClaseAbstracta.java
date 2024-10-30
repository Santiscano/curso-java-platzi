package ClassAbstract;


// Clase principal con el método main
public class EjemploClaseAbstracta {
    public static void main(String[] args) {
        // Crear objetos de las clases concretas
        Perro miPerro = new Perro("Bobby");
        Gato miGato = new Gato("Whiskers");

        // Llamar a métodos comunes (heredados de la clase abstracta)
        miPerro.dormir();
        miPerro.hacerSonido();
        miPerro.moverse();
        miPerro.buscarPelota(); // Método específico de la clase Perro

        System.out.println();

        miGato.dormir();
        miGato.hacerSonido();
        miGato.moverse();
        miGato.cazarRatones(); // Método específico de la clase Gato
    }
}
