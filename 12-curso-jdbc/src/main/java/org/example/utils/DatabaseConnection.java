package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// crearemos la conexion con singleton
public class DatabaseConnection {
    private static String url = "jdbc:mysql://srv1530.hstgr.io:3306/u789784129_digitalizacion";
    private static String user = "u789784129_digitalizacion";
    private static String password = "T&0x9LR1tU7T";
    private static Connection myConnection;

    public static Connection getInstance() throws SQLException {
        if (myConnection == null) {
            myConnection = DriverManager.getConnection(url, user, password);
        }
        return myConnection;
    }
}
