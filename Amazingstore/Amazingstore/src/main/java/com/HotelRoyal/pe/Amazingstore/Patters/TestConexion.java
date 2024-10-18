package com.HotelRoyal.pe.Amazingstore.Patters;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

    public static void main(String[] args) {
        try {
            // Intentar obtener la conexión
            Connection conexion = ConexionDB.getConexionDB();

            if (conexion != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Error: No se pudo establecer la conexión.");
            }

        } catch (SQLException e) {
            // Capturar cualquier error relacionado con la conexión
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
