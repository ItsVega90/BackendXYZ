package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;
import com.ItsVeGa90.BackendXYZ.mgr.tipoidMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class tipoidFacadeImpl implements tipoidFacade {
    @Autowired
    private tipoidMgr tidMgr;

    @Override
    public void process(tipoidDTO tidDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            tidMgr.save(tidDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public void delete(tipoidDTO tidDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            tidMgr.delete(tidDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public List<tipoidDTO> selectAll() throws exceptionFacade {
        managerConexion.getInstance().Open();
        try {
            return tidMgr.selectAll();
        } catch (Exception e) {
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }
}
