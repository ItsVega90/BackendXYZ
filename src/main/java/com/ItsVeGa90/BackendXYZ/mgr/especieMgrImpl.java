package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dao.especieDAO;
import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class especieMgrImpl implements especieMgr {
    @Autowired
    private especieDAO espDAO;

    @Override
    public void save(especieDTO espDTO) throws exceptionManager {
        try {
            especieDTO tp = espDAO.selectById(espDTO);
            if (tp == null) {
                espDAO.insert(espDTO);
            } else {
                espDAO.update(espDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public void delete(especieDTO espDTO) throws exceptionManager {
        try {
            especieDTO tp = espDAO.selectById(espDTO);
            if (tp != null) {
                espDAO.delete(espDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public List<especieDTO> selectAll() throws exceptionManager {
        try {
            return espDAO.selectAll();
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }
}
