/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gugle
 */
public class MyConnection{
    private Connection connection;
    private boolean okConnection;
    private String ok;
    
    public MyConnection ()
    {
        connection = null;
        try{
            try { 
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users","postgres", "123");
                okConnection = connection.isValid(1000);
                System.out.println(okConnection ? "TEST OK" : "TEST FAIL");
                ok = okConnection ? "OK" : "TEST FAIL";
            } catch (ClassNotFoundException ex) {
                ok = ex.getMessage();
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error: " + ex);
            ok = ex.getMessage();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isOkConnection() {
        return okConnection;
    }

    public void setOkConnection(boolean okConnection) {
        this.okConnection = okConnection;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
    
    
}
