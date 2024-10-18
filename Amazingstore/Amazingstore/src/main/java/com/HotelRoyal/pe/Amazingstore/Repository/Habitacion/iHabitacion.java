package com.HotelRoyal.pe.Amazingstore.Repository.Habitacion;

import com.HotelRoyal.pe.Amazingstore.Models.Habitacion;
import java.util.List;

public interface iHabitacion {

    int crear(Habitacion habitacion);

    Habitacion BuscarPorId(long id);

    List<Habitacion> Listar();

    int Editar(Habitacion habitacion);

    int Eliminar(int id);
}
