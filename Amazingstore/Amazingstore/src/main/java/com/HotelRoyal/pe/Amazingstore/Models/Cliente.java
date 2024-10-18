package com.HotelRoyal.pe.Amazingstore.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente implements Serializable {


        private int id;
        private String nombre;
        private String apellido;
        private String telefono;
        private String dni;

        // Lombok generará automáticamente getters, setters, toString, etc.
    }
