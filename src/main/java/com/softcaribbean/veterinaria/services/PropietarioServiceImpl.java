package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.MgrException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.manager.PropietarioMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PropietarioServiceImpl implements PropietarioService {
    private PropietarioMGR propietarioMGR;
    public PropietarioServiceImpl(PropietarioMGR propietarioMGR){
        this.propietarioMGR = propietarioMGR;
    }
    public void createPropietario(Propietario pro) throws ServiceException {

        try {
            propietarioMGR.saveOrInsert(pro);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    public void eliminarPropietarios(int nmid) throws ServiceException {
        try {
            propietarioMGR.delete(nmid);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Map<String,Object>> mostrarPropietarios() throws ServiceException {
        List<Map<String,Object>> propietarios;

        try {
            propietarios = propietarioMGR.getAll();
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return propietarios;
    }
}
