package com.ItsVeGa90.BackendXYZ.mgr;

import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionManager;

import java.util.*;

public interface clienteMgr {
    public void save(clienteDTO cliDTO) throws exceptionManager;

    public void delete(clienteDTO cliDTO) throws exceptionManager;

    public List<clienteDTO> selectAll() throws exceptionManager;
}
