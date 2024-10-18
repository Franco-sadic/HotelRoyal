package com.HotelRoyal.pe.Amazingstore.Controllers;

import com.HotelRoyal.pe.Amazingstore.Models.Reserva;
import com.HotelRoyal.pe.Amazingstore.Services.ServiceReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ApiRestReserva {

    @Autowired
    private ServiceReserva serviceReserva;

    @GetMapping("/listar")
    public List<Reserva> listar() {
        return serviceReserva.listar();
    }

    @PostMapping("/crear")
    public int crear(@RequestBody Reserva reserva) {
        return serviceReserva.crear(reserva);
    }

    @PutMapping("/editar")
    public int editar(@RequestBody Reserva reserva) {
        return serviceReserva.editar(reserva);
    }

    @DeleteMapping("/eliminar")
    public int eliminar(@RequestParam int id) {
        return serviceReserva.eliminar(id);
    }
}
