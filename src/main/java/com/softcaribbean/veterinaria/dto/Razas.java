package com.softcaribbean.veterinaria.dto;

import lombok.Data;

@Data
public class Raza {
    private int nmid;
    private String nombre_raza;
    private Especie especie;
}
