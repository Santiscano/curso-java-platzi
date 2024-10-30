import static java.lang.Math.*;
import static ui.uiMenu.showMonths; // importamos el metodo showMonths de la clase uiMenu

public class Main {
    public static void main(String[] args) {
        System.out.println("Import static de Math" + PI); // como es static no tengo que escribir Math.PI, pero podria hacerlo sin problemas
        Doctor doctor = new Doctor(); // instanciamos un objeto de tipo Doctor
        doctor.name = "Santiago sierra";
        doctor.showName();
        doctor.showId();

        Doctor doctorAdmin = new Doctor();
        doctorAdmin.name = "Admin";
        doctorAdmin.showName();
        doctorAdmin.showId();

        System.out.println("Id doctor: " + Doctor.id);

        showMonths();
    }
}