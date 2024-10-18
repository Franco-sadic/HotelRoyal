package com.HotelRoyal.pe.Amazingstore.Services;

import com.HotelRoyal.pe.Amazingstore.Models.Habitacion;
import com.HotelRoyal.pe.Amazingstore.Repository.Habitacion.iHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHabitacion {

    @Autowired
    private iHabitacion repositoryHabitacion;

    public List<Habitacion> Listar() {
        return repositoryHabitacion.Listar();
    }

    public int crear(Habitacion habitacion) {
        return repositoryHabitacion.crear(habitacion);
    }

    public Habitacion BuscarPorId(long id) {
        return repositoryHabitacion.BuscarPorId(id);
    }

    public int Editar(Habitacion habitacion) {
        return repositoryHabitacion.Editar(habitacion);
    }

    public int Eliminar(int id) {
        return repositoryHabitacion.Eliminar(id);
    }
}
