package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;
import com.ItsVeGa90.BackendXYZ.mgr.clienteMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class clienteFacadeImpl implements clienteFacade {
    @Autowired
    private clienteMgr cliMgr;

    @Override
    public void process(clienteDTO cliDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            cliMgr.save(cliDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public void delete(clienteDTO cliDTO) throws exceptionFacade {
        try {
            managerConexion.getInstance().Open();
            cliMgr.delete(cliDTO);
            managerConexion.getInstance().Commit();
        } catch (Exception e) {
            managerConexion.getInstance().Rollback();
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }

    @Override
    public List<clienteDTO> selectAll() throws exceptionFacade {
        managerConexion.getInstance().Open();
        try {
            return cliMgr.selectAll();
        } catch (Exception e) {
            throw new exceptionFacade(e);
        } finally {
            managerConexion.getInstance().Close();
        }
    }
}
