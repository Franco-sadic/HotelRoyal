package com.HotelRoyal.pe.Amazingstore.Repository.Cliente;

import com.HotelRoyal.pe.Amazingstore.Models.Cliente;
import com.HotelRoyal.pe.Amazingstore.Patters.ConexionDB;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Repository
public class iClienteImpl implements iCliente {

    @Override
    public int crear(Cliente cliente) {
        String SQL = "INSERT INTO Cliente(Nombre, Apellido, Telefono, DNI) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setString(4, cliente.getDni());

            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public Cliente buscarPorId(long id) {
        String SQL = "SELECT id, Nombre, Apellido, Telefono, DNI FROM Cliente WHERE id = ?";
        Cliente cliente = null;

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellido(rs.getString("Apellido"));
                    cliente.setTelefono(rs.getString("Telefono"));
                    cliente.setDni(rs.getString("DNI"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        String SQL = "SELECT id, Nombre, Apellido, Telefono, DNI FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection con = ConexionDB.getConexionDB();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setDni(rs.getString("DNI"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    @Override
    public int editar(Cliente cliente) {
        String SQL = "UPDATE Cliente SET Nombre = ?, Apellido = ?, Telefono = ?, DNI = ? WHERE id = ?";

        try (Connection con = ConexionDB.getConexionDB();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setString(4, cliente.getDni());
            pstmt.setInt(5, cliente.getId());

            return pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int eliminar(int id) {
        String SQL = "DELETE FROM Cliente WHERE id = ?";

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