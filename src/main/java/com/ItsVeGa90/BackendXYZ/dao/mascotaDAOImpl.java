package com.ItsVeGa90.BackendXYZ.dao;

import com.ItsVeGa90.BackendXYZ.database.managerConexion;
import com.ItsVeGa90.BackendXYZ.dto.clienteDTO;
import com.ItsVeGa90.BackendXYZ.dto.especieDTO;
import com.ItsVeGa90.BackendXYZ.dto.mascotaDTO;
import com.ItsVeGa90.BackendXYZ.dto.tipoidDTO;
import com.ItsVeGa90.BackendXYZ.exception.exceptionDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public class mascotaDAOImpl implements mascotaDAO {
    String INSERT = "INSERT INTO mascota (idm, nombrem, especiem, razam, fechanacimientom, fechaentradam, clientem) VALUES (?,?);";
    String UPDATE = "UPDATE mascota SET nombrem=?, especiem=?, razam=?, fechanacimientom=?, fechaentradam=?, clientem=? WHERE idm=?;";
    String DELETE = "DELETE FROM mascota WHERE idm=?;";
    String SELECTBYID = "SELECT M.idm, M.nombrem, M.especiem, E.nombree, M.razam, M.fechanacimientom, M.fechaentradam, M.clientem, C.tipoidc, T.nombret, C.identificacionc, C.nombrec, C.ciudadc, C.direccionc, C.telefonoc\n" +
            "FROM mascota as M \n" +
            "INNER JOIN cliente as C ON M.clientem = C.idc \n" +
            "INNER JOIN especie as E ON M.especiem = E.ide \n" +
            "INNER JOIN tipoid as T ON C.tipoidc = T.idt\n" +
            "WHERE idm=?\n" +
            "ORDER BY M.idm ASC";
    String SELECTALL = "SELECT M.idm, M.nombrem, M.especiem, E.nombree, M.razam, M.fechanacimientom, M.fechaentradam, M.clientem, C.tipoidc, T.nombret, C.identificacionc, C.nombrec, C.ciudadc, C.direccionc, C.telefonoc\n" +
            "FROM mascota as M \n" +
            "INNER JOIN cliente as C ON M.clientem = C.idc \n" +
            "INNER JOIN especie as E ON M.especiem = E.ide \n" +
            "INNER JOIN tipoid as T ON C.tipoidc = T.idt\n" +
            "ORDER BY M.idm ASC";

    @Override
    public void insert(mascotaDTO masDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, masDTO.getIdm());
            statement.setString(2, masDTO.getNombrem());
            statement.setInt(3, masDTO.getEspeciem().getIde());
            statement.setString(4, masDTO.getRazam());
            statement.setDate(5, masDTO.getFechanacimientom());
            statement.setDate(6, masDTO.getFechaentradam());
            statement.setInt(7, masDTO.getClientem().getIdc());
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
    public void update(mascotaDTO masDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, masDTO.getNombrem());
            statement.setInt(2, masDTO.getEspeciem().getIde());
            statement.setString(3, masDTO.getRazam());
            statement.setDate(4, masDTO.getFechanacimientom());
            statement.setDate(5, masDTO.getFechaentradam());
            statement.setInt(6, masDTO.getClientem().getIdc());
            statement.setInt(7, masDTO.getIdm());
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
    public void delete(mascotaDTO masDTO) throws exceptionDAO {
        PreparedStatement statement = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, masDTO.getIdm());
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
    public mascotaDTO selectById(mascotaDTO masDTO) throws exceptionDAO {
        mascotaDTO result = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTBYID);
            statement.setInt(1, masDTO.getIdm());
            statement.executeQuery();
            while (resultSet.next()) {
                result = new mascotaDTO();
                result.setIdm(resultSet.getInt("idm"));
                result.setNombrem(resultSet.getString("nombrem"));

                especieDTO espDTO = new especieDTO();
                espDTO.setIde(resultSet.getInt("especiem"));
                espDTO.setNombree(resultSet.getString("nombree"));
                result.setEspeciem(espDTO);

                result.setRazam(resultSet.getString("razam"));
                result.setFechanacimientom(resultSet.getDate("fechanacimientom"));
                result.setFechaentradam(resultSet.getDate("fechaentradam"));

                clienteDTO cliDTO = new clienteDTO();
                cliDTO.setIdc(resultSet.getInt("clientem"));

                tipoidDTO tidDTO = new tipoidDTO();
                tidDTO.setIdt(resultSet.getInt("tipoidc"));
                tidDTO.setNombret(resultSet.getString("nombret"));
                cliDTO.setTipoidc(tidDTO);

                cliDTO.setIdentificacionc(resultSet.getString("identificacionc"));
                cliDTO.setNombrec(resultSet.getString("nombrec"));
                cliDTO.setCiudadc(resultSet.getString("ciudadc"));
                cliDTO.setDireccionc(resultSet.getString("direccionc"));
                cliDTO.setTelefonoc(resultSet.getString("telefonoc"));
                result.setClientem(cliDTO);
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
    public List<mascotaDTO> selectAll() throws exceptionDAO {
        List<mascotaDTO> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = managerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(SELECTALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                mascotaDTO result = new mascotaDTO();
                result.setIdm(resultSet.getInt("idm"));
                result.setNombrem(resultSet.getString("nombrem"));

                especieDTO espDTO = new especieDTO();
                espDTO.setIde(resultSet.getInt("especiem"));
                espDTO.setNombree(resultSet.getString("nombree"));
                result.setEspeciem(espDTO);

                result.setRazam(resultSet.getString("razam"));
                result.setFechanacimientom(resultSet.getDate("fechanacimientom"));
                result.setFechaentradam(resultSet.getDate("fechaentradam"));

                clienteDTO cliDTO = new clienteDTO();
                cliDTO.setIdc(resultSet.getInt("clientem"));

                tipoidDTO tidDTO = new tipoidDTO();
                tidDTO.setIdt(resultSet.getInt("tipoidc"));
                tidDTO.setNombret(resultSet.getString("nombret"));
                cliDTO.setTipoidc(tidDTO);

                cliDTO.setIdentificacionc(resultSet.getString("identificacionc"));
                cliDTO.setNombrec(resultSet.getString("nombrec"));
                cliDTO.setCiudadc(resultSet.getString("ciudadc"));
                cliDTO.setDireccionc(resultSet.getString("direccionc"));
                cliDTO.setTelefonoc(resultSet.getString("telefonoc"));
                result.setClientem(cliDTO);
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
