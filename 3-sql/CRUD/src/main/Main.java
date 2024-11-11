package org.example.platzi.main;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;
import org.example.platzi.view.SwingApp;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        // *Con estas 2 lineas se veria la ventana de la aplicacion
        // SwingApp app = new SwingApp();
        // app.setVisible(true);

        try (Connection myConn = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();

            System.out.println("---Listando-----");
            repository.findAll().forEach(System.out::println);

            System.out.println("---Empleado eliminado-----");
            repository.delete(6);

            System.out.println("---Listando-----");
            repository.findAll().forEach(System.out::println);

        }

    }
}
