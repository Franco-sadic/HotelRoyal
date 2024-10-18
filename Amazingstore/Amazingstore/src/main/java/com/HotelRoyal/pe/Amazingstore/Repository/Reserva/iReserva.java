package com.HotelRoyal.pe.Amazingstore.Repository.Reserva;

import com.HotelRoyal.pe.Amazingstore.Models.Reserva;

import java.util.List;

public interface iReserva {

    public int crear(Reserva reserva);

    public Reserva BuscarPorId(long id);

    public List<Reserva> Listar();

    public int Editar(Reserva reserva);

    public int Eliminar(int id);


}