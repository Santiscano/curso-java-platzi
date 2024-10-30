public class Patient extends User {
    private String historyClinic;

    public Patient(String name, String email, String historyClinic) {
        super(name, email);
        this.historyClinic = historyClinic;
    }

    public String getHistoryClinic() {
        return "Hola " + super.getName() + " este es su historial clinico: " + historyClinic;
    }

    // sobreescribimos el metodo getDataUser de la clase User, esto se llama polimorfismo
    @Override
    public String getDataUser() {
        return super.getDataUser() + ", Historial: " + historyClinic;
    }
}
