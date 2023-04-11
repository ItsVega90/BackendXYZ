package com.ItsVeGa90.BackendXYZ.facade;

import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionFacade;

import java.util.*;

public interface clienteFacade {
    public void process(clienteDTO cliDTO) throws exceptionFacade;

    public void delete(clienteDTO cliDTO) throws exceptionFacade;

    public List<clienteDTO> selectAll() throws exceptionFacade;
}
