package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;

import java.util.List;

public interface clienteDAO {
    public void insert(clienteDTO cliDTO) throws exceptionDAO;

    public void update(clienteDTO cliDTO) throws exceptionDAO;

    public void delete(clienteDTO cliDTO) throws exceptionDAO;

    public clienteDTO selectById(clienteDTO cliDTO) throws exceptionDAO;

    public List<clienteDTO> selectAll() throws exceptionDAO;
}
