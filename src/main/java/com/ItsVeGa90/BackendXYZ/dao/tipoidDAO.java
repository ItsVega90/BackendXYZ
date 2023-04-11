package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;

import java.util.List;

public interface tipoidDAO {
    public void insert(tipoidDTO tidDTO) throws exceptionDAO;

    public void update(tipoidDTO tidDTO) throws exceptionDAO;

    public void delete(tipoidDTO tidDTO) throws exceptionDAO;

    public tipoidDTO selectById(tipoidDTO tidDTO) throws exceptionDAO;

    public List<tipoidDTO> selectAll() throws exceptionDAO;
}
