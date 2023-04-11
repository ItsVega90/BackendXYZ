package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;

import java.util.*;

public interface tipoidFacade {
    public void process(tipoidDTO tidDTO) throws exceptionFacade;

    public void delete(tipoidDTO tidDTO) throws exceptionFacade;

    public List<tipoidDTO> selectAll() throws exceptionFacade;
}
