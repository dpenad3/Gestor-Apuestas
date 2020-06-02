/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dao;

/**
 *
 * @author gusta
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection conectarse() {
        String bd = "proyecto"; 
        String usuario = "postgres"; 
        String clave = "Ivonne247*"; 
        try { 
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/"+bd,
                    usuario, clave);
            return conexion;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return null;
    }    
    
}
