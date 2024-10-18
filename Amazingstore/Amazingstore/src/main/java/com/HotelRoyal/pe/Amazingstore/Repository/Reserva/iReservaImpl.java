package com.HotelRoyal.pe.Amazingstore.Repository.Reserva;

import com.HotelRoyal.pe.Amazingstore.Models.Reserva;
import com.HotelRoyal.pe.Amazingstore.Patters.ConexionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;


@Repository
public class iReservaImpl implements iReserva {

    @Override
    public int crear(Reserva reserva) {
        String SQL = "INSERT INTO Reserva(ID_Habitacion, ID_Cliente, Tipo_reserva, Fecha_inicio, Fecha_fin, Precio) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, reserva.getIdHabitacion());
            pstmt.setInt(2, reserva.getIdCliente());
            pstmt.setString(3, reserva.getTipoReserva());
            pstmt.setDate(4, new java.sql.Date(reserva.getFechaInicio().getTime()));
            pstmt.setDate(5, new java.sql.Date(reserva.getFechaFin().getTime()));
            pstmt.setBigDecimal(6, reserva.getPrecio());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        reserva.setIdReserva(rs.getInt(1)); // Usa el método correcto
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
    public Reserva BuscarPorId(long id) {
        String SQL = "SELECT ID_Reserva, ID_Habitacion, ID_Cliente, Tipo_reserva, Fecha_inicio, Fecha_fin, Precio FROM Reserva WHERE ID_Reserva = ?";
        Reserva reserva = null;

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva(
                            rs.getInt("ID_Reserva"),
                            rs.getInt("ID_Habitacion"),
                            rs.getInt("ID_Cliente"),
                            rs.getString("Tipo_reserva"),
                            rs.getDate("Fecha_inicio"),
                            rs.getDate("Fecha_fin"),
                            rs.getBigDecimal("Precio")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reserva;
    }

    @Override
    public List<Reserva> Listar() {
        String SQL = "SELECT ID_Reserva, ID_Habitacion, ID_Cliente, Tipo_reserva, Fecha_inicio, Fecha_fin, Precio FROM Reserva";
        List<Reserva> reservas = new ArrayList<>();

        try (Connection con = ConexionDB.getConexionDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("ID_Reserva"),
                        rs.getInt("ID_Habitacion"),
                        rs.getInt("ID_Cliente"),
                        rs.getString("Tipo_reserva"),
                        rs.getDate("Fecha_inicio"),
                        rs.getDate("Fecha_fin"),
                        rs.getBigDecimal("Precio")
                );
                reservas.add(reserva);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reservas;
    }

    @Override
    public int Editar(Reserva reserva) {
        String SQL = "UPDATE Reserva SET ID_Habitacion = ?, ID_Cliente = ?, Tipo_reserva = ?, Fecha_inicio = ?, Fecha_fin = ?, Precio = ? WHERE ID_Reserva = ?";

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setInt(1, reserva.getIdHabitacion());
            pstmt.setInt(2, reserva.getIdCliente());
            pstmt.setString(3, reserva.getTipoReserva());
            pstmt.setDate(4, new java.sql.Date(reserva.getFechaInicio().getTime()));
            pstmt.setDate(5, new java.sql.Date(reserva.getFechaFin().getTime()));
            pstmt.setBigDecimal(6, reserva.getPrecio());


            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int Eliminar(int id) {
        String SQL = "DELETE FROM Reserva WHERE ID_Reserva = ?";

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