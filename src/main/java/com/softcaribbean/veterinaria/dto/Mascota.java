package com.softcaribbean.veterinaria.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Mascota implements Serializable {
    private int nmid;
    private String nombre_mascota;
    private int nmid_raza;
    private Date f_naci;
    private Propietario propietario;
    private Timestamp f_reg;


}
