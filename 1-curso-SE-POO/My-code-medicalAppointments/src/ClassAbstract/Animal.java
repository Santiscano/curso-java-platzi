package ClassAbstract;

// Clase abstracta Animal
abstract class Animal {
    // Atributo común para todos los animales
    private String nombre;

    // Constructor para inicializar el nombre
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método concreto para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método concreto que puede ser sobrescrito por las subclases
    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }

    // Método abstracto para el sonido del animal, y son obligatorio
    public abstract void hacerSonido();

    // Método abstracto para el movimiento del animal
    public abstract void moverse();
}