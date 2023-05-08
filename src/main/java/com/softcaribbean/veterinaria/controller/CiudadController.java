package com.softcaribbean.veterinaria.controller;

import com.softcaribbean.veterinaria.exception.ControllerException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.msg.Mensajes;
import com.softcaribbean.veterinaria.services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@Transactional
@Service
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost/4200")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService){
        this.ciudadService = ciudadService;

    }
    @CrossOrigin(origins = "http://localhost/4200")
    @GetMapping("/ciudad/mostrar_ciudad")
    public ResponseEntity<Mensajes> getCiudad() throws ControllerException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> ciudades;
        try {
            ciudades = ciudadService.mostrarCiudades();
            mensajes.setCode("0");
            mensajes.setMensaje("Lista de ciudades...");
            mensajes.setDato(ciudades);

        }catch (ServiceException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }
}
