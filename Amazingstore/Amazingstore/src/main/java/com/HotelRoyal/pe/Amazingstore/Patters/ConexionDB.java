package com.HotelRoyal.pe.Amazingstore.Patters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=HotelRoyal;TrustServerCertificate=True";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "bongi_123";
    private static Connection conexion;

    // Método para obtener la conexión
    public static Connection getConexionDB() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                // Cargar explícitamente el driver
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("No se pudo cargar el driver de SQL Server", e);
            }
        }
        return conexion;
    }

    // Método para verificar la conexión
    public static boolean verificarConexion() {
        try {
            Connection conn = getConexionDB();
            boolean isValid = conn != null && !conn.isClosed();
            System.out.println("Conexión " + (isValid ? "exitosa" : "fallida"));
            return isValid;
        } catch (SQLException e) {
            System.out.println("Error al verificar la conexión: " + e.getMessage());
            return false;
        }
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}