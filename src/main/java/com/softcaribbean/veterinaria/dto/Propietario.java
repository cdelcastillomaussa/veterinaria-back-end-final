package com.softcaribbean.veterinaria.dto;

import lombok.Data;

@Data
public class Propietario  {
    private int nmid;
    private String tipo_doc;
    private String documento;
    private String nombre_propietario;
    private String direccion;
    private String telefono;
    private Ciudad ciudad;

}
