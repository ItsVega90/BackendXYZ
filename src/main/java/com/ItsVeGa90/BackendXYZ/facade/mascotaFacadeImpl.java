package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;
import com.ItsVeGa90.BackendXYZ.mgr.mascotaMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class mascotaFacadeImpl implements mascotaFacade {
    @Autowired
    private mascotaMgr masMgr;

    @Override
    public void process(mascotaDTO masDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            masMgr.save(masDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public void delete(mascotaDTO masDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            masMgr.delete(masDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public List<mascotaDTO> selectAll() throws exceptionFacade {
        managerConexion.getInstance().Open();
        try {
            return masMgr.selectAll();
        } catch (Exception e) {
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }
}
