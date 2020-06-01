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
import co.vinni.dao.Conexion;
import co.vinni.dto.Registrodatos;
import co.vinni.servicios.Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Operacion {

    private static final Logger LOG = LogManager.getLogger(Operacion.class);

    public boolean login(int cedula, String contrasena) throws SQLException {

        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex == null) {
            return false;
        } else {
            try {
                LOG.info("CONEXION");
                LOG.debug("Clase operacion para la autenticacion del usuario");
                PreparedStatement ps = conex.prepareStatement("select * from public.registros where cedula=? and contrasena=? ");
                ps.setInt(1, cedula);
                ps.setString(2, contrasena);
                LOG.debug("Respuesta de la conexion,encontro el usuario");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    LOG.debug("Ingreso al sistema atraves de operacion ");
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                LOG.error("Error en la clase operacion de autenticacion de usuarios");
                System.out.println(e);
            } finally {
                if (conex != null) {
                    conex.close();
                }
            }
        }
        return false;
    }

    public int ingresar(Registrodatos dato) {
        Conexion con = new Conexion();
        Connection cx = con.conectarse();
        if (cx != null) {
            try {
                PreparedStatement ps = cx.prepareStatement("INSERT INTO public.registros(cedula, nombre, apellido, correo, contrasena)VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, dato.getCedula());
                ps.setString(2, dato.getNombre());
                ps.setString(3, dato.getApellido());
                ps.setString(4, dato.getCorreo());
                ps.setString(5, dato.getContrasena());

                int rta = ps.executeUpdate();
                con.desconectarse(cx);
                return rta;

            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(OperacionregistroIm.class.getName()).log(Level.SEVERE, "Error en insercion de registros", ex);
            } finally {
                con.desconectarse(cx);
            }
        }
        return 0;
    }

    public boolean modificar(int cedula, String nombre, String apellido, String correo, String contrasena) {
        PreparedStatement objPreparedStatement = null;
        Conexion con = new Conexion();
        Connection cx = con.conectarse();
        int resInsert = 0;
        String sqlModify = "UPDATE public.registros "
                + "	SET  cedula=?, nombre=?, apellido=?, correo=?, contrasena=?\n"
                + "	WHERE cedula ="+cedula;
        try {
            objPreparedStatement = cx.prepareStatement(sqlModify);
            objPreparedStatement.setInt(1, cedula);
            objPreparedStatement.setString(2, nombre);
            objPreparedStatement.setString(3, apellido);
            objPreparedStatement.setString(4, correo);
            objPreparedStatement.setString(5, contrasena);
            resInsert = objPreparedStatement.executeUpdate();
            objPreparedStatement.close();
            con.desconectarse(cx);
            if (resInsert > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(OperacionregistroIm1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            con.desconectarse(cx);
        }
    }
}
