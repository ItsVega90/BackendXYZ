package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public class especieDAOImpl implements especieDAO {
    String INSERT = "INSERT INTO especie (ide,nombree) VALUES (?,?);";
    String UPDATE = "UPDATE especie SET nombree=? WHERE ide=?;";
    String DELETE = "DELETE FROM especie WHERE ide=?;";
    String SELECTALL = "SELECT ide, nombree FROM especie;";
    String SELECTBYID = "SELECT ide, nombree FROM especie WHERE ide=?;";

    @Override
    public void insert(especieDTO espDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, espDTO.getIde());
            statement.setString(2, espDTO.getNombree());
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
    public void update(especieDTO espDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, espDTO.getNombree());
            statement.setInt(2, espDTO.getIde());
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
    public void delete(especieDTO espDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, espDTO.getIde());
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
    public especieDTO selectById(especieDTO espDTO) throws exceptionDAO {
        especieDTO result = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTBYID);
            statement.setInt(1, espDTO.getIde());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new especieDTO();
                result.setIde(resultSet.getInt("ide"));
                result.setNombree(resultSet.getString("nombree"));
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
    public List<especieDTO> selectAll() throws exceptionDAO {
        List<especieDTO> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                especieDTO espDTO = new especieDTO();
                espDTO.setIde(resultSet.getInt("ide"));
                espDTO.setNombree(resultSet.getString("nombree"));
                list.add(espDTO);
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
