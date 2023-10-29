package com.softcaribbean.veterinaria.controller;

import com.softcaribbean.veterinaria.exception.ControllerException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.msg.Mensajes;
import com.softcaribbean.veterinaria.services.RazaService;
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
public class RazaController {
    @Autowired
    private RazaService razaService;
    public RazaController(RazaService razaService){
        this.razaService = razaService;
    }
    @GetMapping("/raza/mostrar_razas")
    public ResponseEntity<Mensajes> getRazasByEspecie(@RequestParam int nmid) throws ControllerException {
        Mensajes mensajes = new Mensajes();
        List<Map<String, Object>> razas;
        try {
            razas = razaService.getRazasByEspecie(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Lista de razas...");
            mensajes.setDato(razas);
        } catch (ServiceException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("Fallo " + ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok(mensajes);

    }


}
