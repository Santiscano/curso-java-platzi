package Appointment;

import java.util.ArrayList;
import java.util.Date;

public class Appoinment implements IScheludable {

    @Override
    public boolean schelude(Date date, String time) {
        if (date == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ArrayList<Date> appoinmentsAvailable(Date date) {
        // Crear una lista de fechas
        ArrayList<Date> listDates = new ArrayList<>();

        // Crear fechas y agregarlas a la lista
        listDates.add(new Date());
        listDates.add(new Date(2023 - 1900, 9 - 1, 22)); // 22 de Septiembre de 2023
        listDates.add(new Date(2022 - 1900, 6-1, 17)); // 17 de Junio de 2022

        // Imprimir todas las fechas
        for (Date datePrint : listDates) {
            System.out.println(datePrint);
        }

        // obtener un elemento por su indice
        System.out.println("Primera fecha: " + listDates.getFirst());
        System.out.println("Primera fecha: " + listDates.get(3));
        System.out.println("longitude: " + listDates.size());

        return listDates;
    }
}
