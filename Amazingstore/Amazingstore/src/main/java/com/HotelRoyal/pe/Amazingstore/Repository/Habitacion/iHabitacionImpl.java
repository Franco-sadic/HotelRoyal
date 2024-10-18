package com.HotelRoyal.pe.Amazingstore.Repository.Habitacion;

import com.HotelRoyal.pe.Amazingstore.Models.Habitacion;
import com.HotelRoyal.pe.Amazingstore.Patters.ConexionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class iHabitacionImpl implements iHabitacion {

    @Override
    public int crear(Habitacion habitacion) {
        String SQL = "INSERT INTO Habitacion (Numero, Tipo, Capacidad, Precio) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, habitacion.getNumero());
            pstmt.setString(2, habitacion.getTipo());
            pstmt.setString(3, habitacion.getCapacidad());
            pstmt.setDouble(4, habitacion.getPrecio());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        habitacion.setId(rs.getInt(1));
                    }
                }
            }
            return affectedRows;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public Habitacion BuscarPorId(long id) {
        String SQL = "SELECT ID_Habitacion, Numero, Tipo, Capacidad, Precio FROM Habitacion WHERE ID_Habitacion = ?";
        Habitacion habitacion = null;

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    habitacion = new Habitacion(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDouble(5)
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return habitacion;
    }

    @Override
    public List<Habitacion> Listar() {
        String SQL = "SELECT ID_Habitacion, Numero, Tipo, Capacidad, Precio FROM Habitacion";
        List<Habitacion> habitaciones = new ArrayList<>();

        try (Connection con = ConexionDB.getConexionDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Habitacion habitacion = new Habitacion(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5)
                );
                habitaciones.add(habitacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return habitaciones;
    }

    @Override
    public int Editar(Habitacion habitacion) {
        String SQL = "UPDATE Habitacion SET Numero = ?, Tipo = ?, Capacidad = ?, Precio = ? WHERE ID_Habitacion = ?";

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, habitacion.getNumero());
            pstmt.setString(2, habitacion.getTipo());
            pstmt.setString(3, habitacion.getCapacidad());
            pstmt.setDouble(4, habitacion.getPrecio());
            pstmt.setInt(5, habitacion.getId());

            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int Eliminar(int id) {
        String SQL = "DELETE FROM Habitacion WHERE ID_Habitacion = ?";

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
