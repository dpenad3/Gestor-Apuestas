/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dao;

import co.dpenad3.dto.Datos;
import co.dpenad3.bd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
public class Consultas {

    public Datos registrarTarjeta(Datos obj)
    {
        Connection objConexion=null;
        ResultSet rs= null;
        int resInsert = 0;

        try
        {
           objConexion = ConexionBD.obtenerConexionBaseDeDatos();
           
           PreparedStatement select = objConexion.prepareStatement("SELECT cv, fecha_ven, cupo_disp FROM banco WHERE numero_tarjeta= ?");
           select.setLong(1, obj.getNumero_tarjeta());
           rs = select.executeQuery();
           int cupo_disp=0;
           if(rs.next())
           {
               cupo_disp = rs.getInt("cupo_disp");

           }

           if(rs.getInt("cv")==obj.getCv() && rs.getString("fecha_ven").equals(obj.getFecha_ven()) && cupo_disp>=obj.getDinero())
           {
               PreparedStatement insert = objConexion.prepareStatement("INSERT INTO tarjeta(cedula_jugador, numero_tarjeta, dinero) VALUES (?,?,?);");
               insert.setInt(1, obj.getCedula_jugador());
               insert.setLong(2, obj.getNumero_tarjeta());
               insert.setInt(3, obj.getDinero());
               resInsert = insert.executeUpdate();
               insert.close();
           }
           else
           {
               System.out.println("Los datos no coinciden o no hay la cantidad suficiente de cupo disponible");
           }
          
        }

        catch(SQLException e)
        {
            System.out.println(e);
            System.out.println("Error al registrar Tarjeta");
        }
        finally
        {
            try {
                rs.close();
                objConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(resInsert > 0)
        {
            return obj;
        }
        else
        {
            return null;
        }
    }
    
   
}
