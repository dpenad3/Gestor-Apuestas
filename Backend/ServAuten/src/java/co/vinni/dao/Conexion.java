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

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;

public class Conexion {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Conexion.class);
    public Connection conectarse() {
        LOG.info("Conexion a la BASE DE DATOS");
        String bd = "wplay"; 
        String usuario = "demo"; 
        String clave = "demo"; 
        try {
            LOG.info("Ingreso a la clase conexion");
            LOG.debug("Encontro el driver para la conexion a la base");
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/"+bd,
                    usuario, clave);
            return conexion;
        } catch (ClassNotFoundException ex) {
            LOG.error("Hay un error al registrar el driver para la conexion de la base de datos");
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        } catch (java.sql.SQLException sqle) {
            LOG.error("Hay un error al registrar el driver para la conexion de la base de datos, su error es:");
            System.out.println("Error: " + sqle);
        }
        return null;
    } 
    
    public void desconectarse(Connection conx){
        if(conx != null){
            try {
                conx.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al cerrar la conexion", ex);
            }
        }
    }
    
   // public static void main(String[] args) {
   //     Conexion con= new Conexion();
   //    Connection cx= con.conectarse();
   //     System.out.println("Conecto respuesta"+cx);
   //}
    
}
