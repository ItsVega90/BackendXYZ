package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dao.tipoidDAO;
import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class tipoidMgrImpl implements tipoidMgr {

    @Autowired
    private tipoidDAO tidDAO;

    @Override
    public void save(tipoidDTO tidDTO) throws exceptionManager {
        try {
            tipoidDTO tp = tidDAO.selectById(tidDTO);
            if (tp == null) {
                tidDAO.insert(tidDTO);
            } else {
                tidDAO.update(tidDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public void delete(tipoidDTO tidDTO) throws exceptionManager {
        try {
            tipoidDTO tp = tidDAO.selectById(tidDTO);
            if (tp != null) {
                tidDAO.delete(tidDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public List<tipoidDTO> selectAll() throws exceptionManager {
        try {
            return tidDAO.selectAll();
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }
}
