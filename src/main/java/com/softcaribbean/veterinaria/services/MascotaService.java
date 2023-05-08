package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface MascotaService {
    void createMascota(Mascota pet) throws ServiceException;

    void eliminarMascotas(int nmid) throws ServiceException;

    List<Map<String,Object>> mostrarMascotas() throws ServiceException;
}
