package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;
import com.ItsVeGa90.BackendXYZ.mgr.especieMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class especieFacadeImpl implements especieFacade {
    @Autowired
    private especieMgr espMgr;

    @Override
    public void process(especieDTO espDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            espMgr.save(espDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public void delete(especieDTO espDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            espMgr.delete(espDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public List<especieDTO> selectAll() throws exceptionFacade {
        managerConexion.getInstance().Open();
        try {
            return espMgr.selectAll();
        } catch (Exception e) {
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }
}
