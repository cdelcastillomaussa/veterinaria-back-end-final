package com.softcaribbean.veterinaria.controller;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.exception.ControllerException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.msg.Mensajes;
import com.softcaribbean.veterinaria.services.EspecieService;
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
@CrossOrigin(origins = "http://localhost/4200")
public class EspecieController {
    @Autowired
    private EspecieService especieService;

    public EspecieController(EspecieService especieService) {

        this.especieService = especieService;
    }

    @CrossOrigin(origins = "http://localhost/4200")
    @PostMapping("/especie/create_especie")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Especie especie) throws ServiceException {
        Mensajes mensajes = new Mensajes();
        try{
            especieService.createEspecie(especie);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo la especie con éxito");
        }catch (ServiceException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new ServiceException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }

    @CrossOrigin(origins = "http://localhost/4200")
    @GetMapping("/especie/mostrar_especie")
    public ResponseEntity<Mensajes> getEspecie() throws ControllerException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> especies;
        try {
            especies = especieService.mostrarEspecies();
            mensajes.setCode("0");
            mensajes.setMensaje("Lista de especies...");
            mensajes.setDato(especies);

        }catch (ServiceException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/especie/delete_especie/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws ControllerException {
        Mensajes mensajes = new Mensajes();
        try {
            especieService.eliminarEspecie(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Especie eliminada");
        }catch (ServiceException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }
}
