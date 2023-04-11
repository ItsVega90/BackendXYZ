package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;

import java.util.*;

public interface mascotaFacade {
    public void process(mascotaDTO masDTO) throws exceptionFacade;

    public void delete(mascotaDTO masDTO) throws exceptionFacade;

    public List<mascotaDTO> selectAll() throws exceptionFacade;
}
