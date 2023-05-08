package com.softcaribbean.veterinaria.controller;

import com.softcaribbean.veterinaria.exception.ControllerException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.msg.Mensajes;
import com.softcaribbean.veterinaria.services.EspecieService;
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

}
