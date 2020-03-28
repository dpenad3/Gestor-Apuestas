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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operacion {
    
   public boolean login(int cedula,String contrasena) throws SQLException{
        Conexion c = new Conexion();
        Connection conex = c.conectarse();
        if (conex == null){
            return false;
        }else{
            try {
                PreparedStatement ps = conex.prepareStatement("select * from public.login where cedula=? and contrasena=? ");
                ps.setInt(1, cedula);                
                ps.setString(2, contrasena);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    return true;
                }else{
                   return false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            finally{
                if (conex != null){
                    conex.close();
                }
            }    
        }
        return false;
    }     
    
}
