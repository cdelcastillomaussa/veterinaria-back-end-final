package com.softcaribbean.veterinaria.controller;

import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.ControllerException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.msg.Mensajes;
import com.softcaribbean.veterinaria.services.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Transactional
@Service
@RequestMapping("/api")
public class PropietarioController {
    @Autowired
    private PropietarioService propietarioService;
    public PropietarioController(PropietarioService propietarioService){
        this.propietarioService = propietarioService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/propietario/createpropietario")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Propietario propietario) throws ControllerException {
        Mensajes mensajes = new Mensajes();
        try{
            propietarioService.createPropietario(propietario);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo el propietario con éxito");
        }catch (ServiceException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/propietario/propietarios")
    public ResponseEntity<Mensajes> getPropietarios() throws ControllerException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> propietario;
        try {
            propietario = propietarioService.mostrarPropietarios();
            mensajes.setCode("0");
            mensajes.setMensaje("Listado de propietarios...");
            mensajes.setDato(propietario);

        }catch (ServiceException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/propietario/deletepropietario/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws ControllerException {
        Mensajes mensajes = new Mensajes();
        try {
            propietarioService.eliminarPropietarios(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Propietario eliminado exitosamente!");
        }catch (ServiceException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }
}
