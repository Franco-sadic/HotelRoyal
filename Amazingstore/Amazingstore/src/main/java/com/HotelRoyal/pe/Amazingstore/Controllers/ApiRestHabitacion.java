package com.HotelRoyal.pe.Amazingstore.Controllers;

import com.HotelRoyal.pe.Amazingstore.Models.Habitacion;
import com.HotelRoyal.pe.Amazingstore.Services.ServiceHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitacion")
public class ApiRestHabitacion {

    @Autowired
    private ServiceHabitacion serviceHabitacion;

    @GetMapping("/listar")
    public List<Habitacion> listar() {
        return serviceHabitacion.Listar();
    }

    @PostMapping("/crear")
    public int crear(@RequestBody Habitacion habitacion) {
        return serviceHabitacion.crear(habitacion);
    }

    @PutMapping("/editar/{id}")
    public int editar(@PathVariable int id, @RequestBody Habitacion habitacion) {
        habitacion.setId(id);
        return serviceHabitacion.Editar(habitacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminar(@PathVariable int id) {
        return serviceHabitacion.Eliminar(id);
    }
}
