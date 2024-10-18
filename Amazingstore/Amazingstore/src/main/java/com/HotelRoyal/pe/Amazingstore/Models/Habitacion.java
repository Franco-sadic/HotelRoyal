package com.HotelRoyal.pe.Amazingstore.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion implements Serializable {

    private int id;
    private String numero;
    private String tipo;
    private String capacidad;
    private double precio;


}
