import java.util.ArrayList;
import java.util.Date;

public class Doctor {
    static int id = 0;
    String name;
    String address;

    // este es el constructor, si no lo definimos, java lo crea por defecto
    public void Doctor() {
        id++;
        System.out.println("Constructor de Doctor");
    }

    public void Doctor(String name) {
        this.name = name;
        System.out.println("El nombre del doctor asignado es: " + this.name);
    }

    public void Doctor(String name, String address) {
        this.name = name;
        this.address = address;
        System.out.println("El nombre del doctor asignado es: " + this.name);
        System.out.println("La direccion del doctor asignado es: " + this.address);
    }

    public void showName() {
        System.out.println(name);
    }

    public void showId() {
        System.out.println("Id doctor: " + id);
    }

    // class anidada static
    public  static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
        public void addAvailableAppointment(Date date, String time) {
            availableAppointments.add(new AvailableAppointment(date, time));
        }

    }
}
