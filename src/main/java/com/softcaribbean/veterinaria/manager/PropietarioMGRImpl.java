package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dao.EspecieDAO;
import com.softcaribbean.veterinaria.dao.PropietarioDAO;
import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PropietarioMGRImpl implements PropietarioMGR {
    private PropietarioDAO propietarioDAO;
    public PropietarioMGRImpl(PropietarioDAO propietarioDAO) {
        this.propietarioDAO = propietarioDAO;
    }
    public void saveOrInsert(Propietario prop) throws MgrException {
        try {
            Propietario propietario = propietarioDAO.getById(prop.getNmid());
            if(propietario == null){
                System.out.println("Propietario guardado exitosamente");
                propietarioDAO.insert(prop);
            }else {
                System.out.println("Propietario actualizado exitosamente");
                propietarioDAO.update(prop);
            }
        } catch (DAOException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete(int nmid) throws  MgrException {
        try {
            Propietario propietario = propietarioDAO.getById(nmid);
            if(propietario == null){
                System.out.println("El tomador no existe");
            }else {
                propietarioDAO.delete(nmid);
            }
        } catch (DAOException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public List<Map<String,Object>> getAll() throws  MgrException {
        List<Map<String,Object>>  propietarios;
        try {
            propietarios = propietarioDAO.getAll();
        } catch (DAOException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return propietarios;
    }


}
