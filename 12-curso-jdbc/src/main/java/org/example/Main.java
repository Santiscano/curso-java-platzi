package org.example;

import org.example.utils.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (
                Connection connection = DatabaseConnection.getInstance();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM voucher_numbering")
        ) {
            // Leer resultados del SELECT
            while (resultSet.next()) {
                System.out.println(resultSet.getString("number_voucher_numbering"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
