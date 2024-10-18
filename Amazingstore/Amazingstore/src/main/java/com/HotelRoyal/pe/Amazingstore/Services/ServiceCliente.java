package com.HotelRoyal.pe.Amazingstore.Services;

import com.HotelRoyal.pe.Amazingstore.Models.Cliente;
import com.HotelRoyal.pe.Amazingstore.Repository.Cliente.iCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCliente {

    @Autowired
    private iCliente repositoryCliente;

    public List<Cliente> listar() {
        return repositoryCliente.listar();
    }

    public int crear(Cliente cliente) {
        return repositoryCliente.crear(cliente);
    }

    public Cliente BuscarPorId(long id) {
        return repositoryCliente.buscarPorId(id);
    }

    public int editar(Cliente cliente) {
        return repositoryCliente.editar(cliente);
    }

    public int eliminar(int id) {
        return repositoryCliente.eliminar(id);
    }
}
