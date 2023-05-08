package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.exception.MgrException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.manager.MascotaMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MascotaServiceImpl implements MascotaService {
    private MascotaMGR mascotaMGR;
    public MascotaServiceImpl(MascotaMGR mascotaMGR){
        this.mascotaMGR = mascotaMGR;
    }
    @Override
    public void createMascota(Mascota pet) throws ServiceException {
        try {
            mascotaMGR.saveOrInsert(pet);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void eliminarMascotas(int nmid) throws ServiceException {
        try {
            mascotaMGR.delete(nmid);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Map<String, Object>> mostrarMascotas() throws ServiceException {
        List<Map<String,Object>> mascotas;

        try {
            mascotas = mascotaMGR.getAll();
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return mascotas;
    }
}
