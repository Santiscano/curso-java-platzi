package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // Uso de try-with-resources para autocerrar todos los recursos que se necesiten
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://srv1530.hstgr.io:3306/u789784129_digitalizacion",
                        "u789784129_digitalizacion",
                        "T&0x9LR1tU7T"
                );
                Statement statement = connection.createStatement();
                // Bloque try-with-resources para el ResultSet
                ResultSet resultSet = statement.executeQuery("SELECT * FROM voucher_numbering")
        ) {
            // Leer resultados del SELECT
            while (resultSet.next()) {
                System.out.println(resultSet.getString("number_voucher_numbering"));
            }

            // Bloque try-with-resources para el PreparedStatement de INSERT
            try (PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO voucher_numbering (number_voucher_numbering, letter_voucher_numbering) VALUES (?, ?)")
            ) {
                insertStatement.setInt(1, 25);
                insertStatement.setString(2, "Tomas");
                int rowsAffected = insertStatement.executeUpdate();
                System.out.println("Se insertaron " + rowsAffected + " filas");
            }

            // Bloque try-with-resources para el PreparedStatement de UPDATE
            try (PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE voucher_numbering SET number_voucher_numbering = ? WHERE letter_voucher_numbering = ?")
            ) {
                updateStatement.setInt(1, 26);
                updateStatement.setString(2, "Juan");
                int rowsAffectedUpdate = updateStatement.executeUpdate();
                System.out.println("Se actualizaron " + rowsAffectedUpdate + " filas");
            }

            // Bloque try-with-resources para el PreparedStatement de DELETE
            try (PreparedStatement deleteStatement = connection.prepareStatement(
                    "DELETE FROM voucher_numbering WHERE letter_voucher_numbering = ?")
            ) {
                deleteStatement.setString(1, "Juan");
                int rowsAffectedDelete = deleteStatement.executeUpdate();
                System.out.println("Se eliminaron " + rowsAffectedDelete + " filas");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
