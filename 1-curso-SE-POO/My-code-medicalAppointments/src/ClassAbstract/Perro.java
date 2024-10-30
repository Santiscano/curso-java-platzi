package ClassAbstract;

class Perro extends Animal {

    // Constructor que llama al constructor de la superclase
    public Perro(String nombre) {
        super(nombre);
    }

    // Implementación del método abstracto hacerSonido
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Guau guau!");
    }

    // Implementación del método abstracto moverse
    @Override
    public void moverse() {
        System.out.println(getNombre() + " está corriendo.");
    }

    // Método propio de la clase Perro
    public void buscarPelota() {
        System.out.println(getNombre() + " está buscando una pelota.");
    }
}