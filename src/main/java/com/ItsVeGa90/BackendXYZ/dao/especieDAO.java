package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;

import java.util.List;

public interface especieDAO {
    public void insert(especieDTO espDTO) throws exceptionDAO;

    public void update(especieDTO espDTO) throws exceptionDAO;

    public void delete(especieDTO espDTO) throws exceptionDAO;

    public especieDTO selectById(especieDTO espDTO) throws exceptionDAO;

    public List<especieDTO> selectAll() throws exceptionDAO;
}
