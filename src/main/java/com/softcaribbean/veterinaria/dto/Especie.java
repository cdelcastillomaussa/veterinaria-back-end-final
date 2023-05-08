package com.softcaribbean.veterinaria.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class Especie implements Serializable {
    private int nmid;
    private String nombre_especie;
}
