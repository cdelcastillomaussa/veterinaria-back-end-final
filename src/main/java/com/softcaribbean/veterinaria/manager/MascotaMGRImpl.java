package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dao.MascotaDAO;
import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MascotaMGRImpl implements MascotaMGR {
    private MascotaDAO mascotaDAO;
    public MascotaMGRImpl(MascotaDAO mascotaDAO){
        this.mascotaDAO = mascotaDAO;
    }
    public void saveOrInsert(Mascota pet) throws MgrException {
        try {
            Mascota mascota = mascotaDAO.getById(pet.getNmid());
            if(mascota == null){
                System.out.println("Mascota guardada exitosamente");
                mascotaDAO.insert(pet);
            }else {
                System.out.println("Mascota actualizada exitosamente");
                mascotaDAO.update(pet);
            }
        } catch (DAOException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete(int nmid) throws  MgrException {
        try {
            Mascota mascota = mascotaDAO.getById(nmid);
            if(mascota == null){
                System.out.println("La mascota no existe");
            }else {
                mascotaDAO.delete(nmid);
            }
        } catch (DAOException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws  MgrException {
        List<Map<String,Object>>  mascotas;
        try {
            mascotas = mascotaDAO.getAll();
        } catch (DAOException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return mascotas;
    }
}
