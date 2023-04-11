package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dao.mascotaDAO;
import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class mascotaMgrImpl implements mascotaMgr {
    @Autowired
    private mascotaDAO masDAO;

    @Override
    public void save(mascotaDTO masDTO) throws exceptionManager {
        try {
            mascotaDTO tp = masDAO.selectById(masDTO);
            if (tp == null) {
                masDAO.insert(masDTO);
            } else {
                masDAO.update(masDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public void delete(mascotaDTO masDTO) throws exceptionManager {
        try {
            mascotaDTO tp = masDAO.selectById(masDTO);
            if (tp != null) {
                masDAO.delete(masDTO);
            }
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }

    @Override
    public List<mascotaDTO> selectAll() throws exceptionManager {
        try {
            return masDAO.selectAll();
        } catch (Exception e) {
            throw new exceptionManager(e);
        }
    }
}
