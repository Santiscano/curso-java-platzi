package ClassAbstract;

// Clase concreta Gato que extiende de Animal
class Gato extends Animal {

    // Constructor que llama al constructor de la superclase
    public Gato(String nombre) {
        super(nombre);
    }

    // Implementación del método abstracto hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Miau miau!");
    }

    // Implementación del método abstracto moverse
    @Override
    public void moverse() {
        System.out.println(getNombre() + " está caminando sigilosamente.");
    }

    // Método propio de la clase Gato
    public void cazarRatones() {
        System.out.println(getNombre() + " está cazando ratones.");
    }
}
