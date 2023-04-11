package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public class clienteDAOImpl implements clienteDAO {
    String INSERT = "INSERT INTO cliente (idc, nombrem, especiem, razam, fechanacimientom, fechaentradam, clientem) VALUES (?,?,?,?,?,?,?);";
    String UPDATE = "UPDATE cliente SET nombrem=?, especiem=?, razam=?, fechanacimientom=?, fechaentradam=?, clientem=?,  WHERE idc=?;";
    String DELETE = "DELETE FROM cliente WHERE idc=?;";
    String SELECTBYID = "SELECT C.idc, C.tipoidc, T.nombret, C.identificacionc, C.nombrec, C.ciudadc, C.direccionc, C.telefonoc \n" +
            "FROM cliente as C \n" +
            "INNER JOIN tipoid as T ON C.tipoidc = T.idt\n" +
            "WHERE idc=?\n" +
            "ORDER BY C.idc ASC;";
    String SELECTALL = "SELECT C.idc, C.tipoidc, T.nombret, C.identificacionc, C.nombrec, C.ciudadc, C.direccionc, C.telefonoc \n" +
            "FROM cliente as C \n" +
            "INNER JOIN tipoid as T ON C.tipoidc = T.idt\n" +
            "ORDER BY C.idc ASC";

    @Override
    public void insert(clienteDTO cliDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, cliDTO.getIdc());
            statement.setInt(2, cliDTO.getTipoidc().getIdt());
            statement.setString(3, cliDTO.getIdentificacionc());
            statement.setString(4, cliDTO.getNombrec());
            statement.setString(5, cliDTO.getCiudadc());
            statement.setString(6, cliDTO.getDireccionc());
            statement.setString(7, cliDTO.getTelefonoc());
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
    public void update(clienteDTO cliDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, cliDTO.getTipoidc().getIdt());
            statement.setString(2, cliDTO.getIdentificacionc());
            statement.setString(3, cliDTO.getNombrec());
            statement.setString(4, cliDTO.getCiudadc());
            statement.setString(5, cliDTO.getDireccionc());
            statement.setString(6, cliDTO.getTelefonoc());
            statement.setInt(7, cliDTO.getIdc());
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
    public void delete(clienteDTO cliDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, cliDTO.getIdc());
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
    public clienteDTO selectById(clienteDTO cliDTO) throws exceptionDAO {
        clienteDTO result = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTBYID);
            statement.setInt(1, cliDTO.getIdc());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new clienteDTO();
                result.setIdc(resultSet.getInt("idc"));

                tipoidDTO tidDTO = new tipoidDTO();
                tidDTO.setIdt(resultSet.getInt("idt"));
                tidDTO.setNombret(resultSet.getString("nombret"));
                result.setTipoidc(tidDTO);

                result.setIdentificacionc(resultSet.getString("identificacionc"));
                result.setNombrec(resultSet.getString("nombrec"));
                result.setCiudadc(resultSet.getString("ciudadc"));
                result.setDireccionc(resultSet.getString("direccionc"));
                result.setTelefonoc(resultSet.getString("telefonoc"));
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
    public List<clienteDTO> selectAll() throws exceptionDAO {
        List<clienteDTO> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clienteDTO result = new clienteDTO();
                result.setIdc(resultSet.getInt("idc"));

                tipoidDTO tidDTO = new tipoidDTO();
                tidDTO.setIdt(resultSet.getInt("tipoidc"));
                tidDTO.setNombret(resultSet.getString("nombret"));
                result.setTipoidc(tidDTO);

                result.setIdentificacionc(resultSet.getString("identificacionc"));
                result.setNombrec(resultSet.getString("nombrec"));
                result.setCiudadc(resultSet.getString("ciudadc"));
                result.setDireccionc(resultSet.getString("direccionc"));
                result.setTelefonoc(resultSet.getString("telefonoc"));
                list.add(result);
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
