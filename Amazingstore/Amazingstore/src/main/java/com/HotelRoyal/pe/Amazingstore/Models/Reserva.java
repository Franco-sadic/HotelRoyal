package com.HotelRoyal.pe.Amazingstore.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva implements Serializable {
    private int idReserva; // Cambiar Object a int
    private int idHabitacion;
    private int idCliente;
    private String tipoReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal precio;


}
