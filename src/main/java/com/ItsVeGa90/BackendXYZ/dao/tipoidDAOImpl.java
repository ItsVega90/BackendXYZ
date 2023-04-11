package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public class tipoidDAOImpl implements tipoidDAO {
    String INSERT = "INSERT INTO tipoid (idt,nombret) VALUES (?,?);";
    String UPDATE = "UPDATE tipoid SET nombret=? WHERE idt=?;";
    String DELETE = "DELETE FROM tipoid WHERE idt=?;";
    String SELECTALL = "SELECT idt, nombret FROM tipoid;";
    String SELECTBYID = "SELECT idt, nombret FROM tipoid WHERE idt=?;";

    @Override
    public void insert(tipoidDTO tidDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, tidDTO.getIdt());
            statement.setString(2, tidDTO.getNombret());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new exceptionDAO(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(tipoidDTO tidDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, tidDTO.getNombret());
            statement.setInt(2, tidDTO.getIdt());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new exceptionDAO(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(tipoidDTO tidDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, tidDTO.getIdt());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new exceptionDAO(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public tipoidDTO selectById(tipoidDTO tidDTO) throws exceptionDAO {
        tipoidDTO result = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTBYID);
            statement.setInt(1, tidDTO.getIdt());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new tipoidDTO();
                result.setIdt(resultSet.getInt("idt"));
                result.setNombret(resultSet.getString("nombret"));
            }

        } catch (Exception e) {
            throw new exceptionDAO(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<tipoidDTO> selectAll() throws exceptionDAO {
        List<tipoidDTO> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tipoidDTO tidDTO = new tipoidDTO();
                tidDTO.setIdt(resultSet.getInt("idt"));
                tidDTO.setNombret(resultSet.getString("nombret"));
                list.add(tidDTO);
            }
        } catch (Exception e) {
            throw new exceptionDAO(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
}
