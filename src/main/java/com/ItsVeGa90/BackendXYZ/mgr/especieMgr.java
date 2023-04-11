package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;

import java.util.*;

public interface especieMgr {
    public void save(especieDTO espDTO) throws exceptionManager;

    public void delete(especieDTO espDTO) throws exceptionManager;

    public List<especieDTO> selectAll() throws exceptionManager;
}
