package com.softcaribbean.veterinaria.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Mascota {
    private int nmid;
    private String nombre_mascota;
    private Especie especie;
    private Razas raza;
    private Date f_naci;
    private Propietario propietario;
    private Date f_reg;

}
