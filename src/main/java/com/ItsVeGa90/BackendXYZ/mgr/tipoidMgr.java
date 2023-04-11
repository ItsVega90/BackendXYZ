package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;

import java.util.*;

public interface tipoidMgr {
    public void save(tipoidDTO tidDTO) throws exceptionManager;

    public void delete(tipoidDTO tidDTO) throws exceptionManager;

    public List<tipoidDTO> selectAll() throws exceptionManager;
}
