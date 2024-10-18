package com.HotelRoyal.pe.Amazingstore.Repository.Cliente;

import com.HotelRoyal.pe.Amazingstore.Models.Cliente;

import java.util.List;

public interface iCliente {
    int crear(Cliente cliente);
    Cliente buscarPorId(long id);
    List<Cliente> listar();
    int editar(Cliente cliente);
    int eliminar(int id);
}
