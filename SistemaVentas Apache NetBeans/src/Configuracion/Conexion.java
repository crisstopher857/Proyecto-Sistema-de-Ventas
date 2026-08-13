/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/sistemaVentas";

    private static final String USUARIO = "postgres";

    private static final String PASSWORD = "5432";

    public static Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a PostgreSQL.");

        } catch (SQLException e) {

            System.out.println(
                    "Error de conexion: " + e.getMessage()
            );
        }

        return conexion;
    }
    
    //Temporal
    public static void main(String[] args) {

    Connection conexion = conectar();

    if (conexion != null) {
        System.out.println("Prueba de conexion correcta.");
    } else {
        System.out.println("No se pudo conectar.");
    }
}
}