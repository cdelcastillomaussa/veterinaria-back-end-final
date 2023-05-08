package com.softcaribbean.veterinaria.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class Ciudad implements Serializable {
    private int nmid;
    private String nombre_ciudad;
    private int codigo;
}
