package ui;

public class uiMenu {
    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; // final significa que no se puede modificar "constante"

    public static  void showMonths() {
        for (int i = 0; i < MONTHS.length; i++) {
            System.out.println(i + 1 + ". " + MONTHS[i]);
        }
    }
}
