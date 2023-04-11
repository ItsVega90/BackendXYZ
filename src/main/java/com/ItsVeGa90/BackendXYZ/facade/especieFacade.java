package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;

import java.util.*;

public interface especieFacade {
    public void process(especieDTO espDTO) throws exceptionFacade;

    public void delete(especieDTO espDTO) throws exceptionFacade;

    public List<especieDTO> selectAll() throws exceptionFacade;
}
