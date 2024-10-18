package com.HotelRoyal.pe.Amazingstore.Controllers;

import com.HotelRoyal.pe.Amazingstore.Models.Cliente;
import com.HotelRoyal.pe.Amazingstore.Services.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ApiRestCliente {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping("/listar")
    public List<Cliente> listar() {
        return serviceCliente.listar();
    }

    @PostMapping("/crear")
    public int crear(@RequestBody Cliente cliente) {
        return serviceCliente.crear(cliente);
    }

    @PutMapping("/editar")
    public int editar(@RequestBody Cliente cliente) {
        return serviceCliente.editar(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminar(@PathVariable int id) {
        return serviceCliente.eliminar(id);
    }
}
