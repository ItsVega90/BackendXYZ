package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dao.clienteDAO;
import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class clienteMgrImpl implements clienteMgr {
    @Autowired
    private clienteDAO cliDAO;


    @Override
    public void save(clienteDTO cliDTO) throws exceptionManager {
        try {
            clienteDTO tp = cliDAO.selectById(cliDTO);
            if (tp == null) {
                cliDAO.insert(cliDTO);
            } else {
                cliDAO.update(cliDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public void delete(clienteDTO cliDTO) throws exceptionManager {
        try {
            clienteDTO tp = cliDAO.selectById(cliDTO);
            if (tp != null) {
                cliDAO.delete(cliDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public List<clienteDTO> selectAll() throws exceptionManager {
        try {
            return cliDAO.selectAll();
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }
}
