package com.softcaribbean.veterinaria.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class Raza implements Serializable {
    private int nmid;
    private String nombre_raza;
    private int nmid_especie;
}
