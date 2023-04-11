package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;

import java.util.List;

public interface mascotaDAO {
    public void insert(mascotaDTO masDTO) throws exceptionDAO;

    public void update(mascotaDTO masDTO) throws exceptionDAO;

    public void delete(mascotaDTO masDTO) throws exceptionDAO;

    public mascotaDTO selectById(mascotaDTO masDTO) throws exceptionDAO;

    public List<mascotaDTO> selectAll() throws exceptionDAO;
}
