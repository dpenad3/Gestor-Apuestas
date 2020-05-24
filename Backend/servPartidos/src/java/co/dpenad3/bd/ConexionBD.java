/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.bd;
import co.dpenad3.utility.DCM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author dani2
 */
public class ConexionBD{

    public static ConexionBD objConexionBD;
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ConexionBD.class);

        //Método que realiza la conexión a la base de datos
        public  Connection obtenerConexionBaseDeDatos()
        {
            try
            {
                Class.forName(DCM.DRIVER_BD);
                Connection conexion = DriverManager.getConnection(DCM.URL_BD,DCM.USUARIO_BD,DCM.CONTRASENA_BD);
                LOG.info("Conectado a la base de datos");
                return conexion;
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, "Error de driver postgres", ex);
                LOG.error("Error de driver postgres", ex);
                
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, "Error de datos de conexion postgres", ex);
                LOG.error("Error de datos de conexion postgres", ex);
            }
            return null;
        }
        
    //Metodo para desconectarse de la base de datos
    public void desConexion(Connection c){
        try {
            c.close();
            LOG.info("Desconexión de la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, "Error al cerrar la conexion", ex);
            LOG.error("Error al cerrar la conexion", ex);
        }
    }
        
}