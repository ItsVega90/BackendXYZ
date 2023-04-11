package com.ItsVeGa90.BackendXYZ.database;

import java.sql.*;

public class managerConexion {
    private static managerConexion Instance;
    private conexion con;

    private managerConexion() {
        con = new conexion();
    }

    public static managerConexion getInstance() {
        if (Instance == null) {
            Instance = new managerConexion();
        }
        return Instance;
    }

    public void Open() {
        con.connet();
    }

    public void Commit() {
        try {
            con.getCon().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Rollback() {
        try {
            con.getCon().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Close() {
        try {
            con.getCon().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con.getCon();
    }
}
