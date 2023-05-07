package com.softcaribbean.veterinaria.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class propietario implements Serializable {
    private int nmid;
    private String tipo_doc;
    private String documento;
    private String nombre_completo;
    private String ciudad;
    private String direccion;
    private String telefono;
    private int nmid_ciudad;
}
