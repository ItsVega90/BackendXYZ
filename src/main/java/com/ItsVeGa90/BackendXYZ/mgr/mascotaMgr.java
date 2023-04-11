package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;

import java.util.*;

public interface mascotaMgr {
    public void save(mascotaDTO masDTO) throws exceptionManager;

    public void delete(mascotaDTO masDTO) throws exceptionManager;

    public List<mascotaDTO> selectAll() throws exceptionManager;
}
