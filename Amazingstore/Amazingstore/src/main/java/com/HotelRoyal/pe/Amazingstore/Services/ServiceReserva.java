package com.HotelRoyal.pe.Amazingstore.Services;

import com.HotelRoyal.pe.Amazingstore.Models.Reserva;
import com.HotelRoyal.pe.Amazingstore.Repository.Reserva.iReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReserva {

    @Autowired
    private iReserva reservaRepository; // Inyectar el repositorio que interactúa con la base de datos

    public List<Reserva> listar() {
        return reservaRepository.Listar(); // Llama al método que consulta la base de datos
    }

    public int crear(Reserva reserva) {
        return reservaRepository.crear(reserva); // Crea una nueva reserva en la base de datos
    }

    public int editar(Reserva reserva) {
        return reservaRepository.Editar(reserva); // Edita la reserva en la base de datos
    }

    public int eliminar(int idReserva) {
        return reservaRepository.Eliminar(idReserva); // Elimina la reserva de la base de datos
    }
}
