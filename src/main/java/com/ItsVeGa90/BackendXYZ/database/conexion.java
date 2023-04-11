package com.ItsVeGa90.BackendXYZ.database;

import java.sql.*;

public class conexion {
    private Connection con = null;

    public Connection getCon() {
        return con;
    }

    public void connet() {
        try {
            String sURL = "jdbc:mysql://localhost:3306/dbxyz";
            con = DriverManager.getConnection(sURL, "root", "");
            con.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
