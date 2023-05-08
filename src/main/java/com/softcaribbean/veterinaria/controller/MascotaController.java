package com.softcaribbean.veterinaria.controller;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.ControllerException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.msg.Mensajes;
import com.softcaribbean.veterinaria.services.MascotaService;
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
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;
    public MascotaController(MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/mascota/createmascota")
    public ResponseEntity<Mensajes> create(@Valid @RequestBody Mascota mascota) throws ControllerException {
        Mensajes mensajes = new Mensajes();
        try{
            mascotaService.createMascota(mascota);
            mensajes.setCode("0");
            mensajes.setMensaje("se creo la mascota con éxito");
        }catch (ServiceException ex){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo "+ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok( mensajes);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/mascota/mascotas")
    public ResponseEntity<Mensajes> getMascotas() throws ControllerException {
        Mensajes mensajes = new Mensajes();
        List<Map<String,Object>> mascota;
        try {
            mascota = mascotaService.mostrarMascotas();
            mensajes.setCode("0");
            mensajes.setMensaje("Listado de mascotas...");
            mensajes.setDato(mascota);

        }catch (ServiceException ex) {
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + ex.getMessage());
            throw new ControllerException(ex);
        }
        return ResponseEntity.ok(mensajes);
    }

    @DeleteMapping("/mascota/deletemascota/{nmid}")
    public ResponseEntity<Mensajes> delete(@Valid  @PathVariable int nmid) throws ControllerException {
        Mensajes mensajes = new Mensajes();
        try {
            mascotaService.eliminarMascotas(nmid);
            mensajes.setCode("0");
            mensajes.setMensaje("Mascota eliminada exitosamente!");
        }catch (ServiceException e){
            mensajes.setCode("1");
            mensajes.setMensaje("fallo " + e.getMessage());
        }
        return ResponseEntity.ok(mensajes);
    }
}
