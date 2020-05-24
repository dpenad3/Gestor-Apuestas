/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dao;

import co.dpenad3.dto.Datos;
import co.dpenad3.bd.ConexionBD;
import co.dpenad3.interfaces.operRegistrarTarjeta;
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
public class Consultas implements operRegistrarTarjeta{

    public Datos registrarTarjeta(Datos obj)
    {
        ConexionBD conn = new ConexionBD();
        Connection objConexion = conn.obtenerConexionBaseDeDatos();
        int resInsert = 0;
        
        if(objConexion!=null){
            try{
                PreparedStatement select = objConexion.prepareStatement("SELECT cv, fecha_ven, cupo_disp FROM banco WHERE numero_tarjeta= ?");
                select.setLong(1, obj.getNumero_tarjeta());
                
                ResultSet rs = select.executeQuery();
                int cupo_disp=0, cv=0;
                String fecha=null;
                if(rs.next())
                {
                    cupo_disp = rs.getInt("cupo_disp");
                    cv = rs.getInt("cv");
                    fecha =  rs.getString("fecha_ven");
                }
                if(cv==obj.getCv() && fecha.equals(obj.getFecha_ven()+"-31") && cupo_disp>=obj.getDinero())
                {
                    PreparedStatement insert = objConexion.prepareStatement("INSERT INTO tarjeta(cedula_jugador, numero_tarjeta, dinero) VALUES (?,?,?);");
                    insert.setInt(1, obj.getCedula_jugador());
                    insert.setLong(2, obj.getNumero_tarjeta());
                    insert.setInt(3, obj.getDinero());
                    resInsert = insert.executeUpdate();
                    insert.close();
                    
                    int gasto = cupo_disp-obj.getDinero();
                    PreparedStatement update = objConexion.prepareStatement("UPDATE banco SET cupo_disp=? WHERE numero_tarjeta=?");
                    update.setInt(1, gasto);
                    update.setLong(2, obj.getNumero_tarjeta());
                    update.executeUpdate();
                    update.close();
                    
                }
                else
                {
                    System.out.println("Los datos no coinciden o no hay la cantidad suficiente de cupo disponible");
                }
            }catch(SQLException e){
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, "Error al registrar la tarjeta", e);
            }finally{
                conn.desConexion(objConexion);
            }
            
            if(resInsert > 0){
                return obj;
            }else{
                return null;
            }
        }else{
           return null; 
        }
    }
    
    public Datos darTarjeta(Datos cedula){
        ConexionBD conn = new ConexionBD();
        Connection objConexion = conn.obtenerConexionBaseDeDatos();
        Datos dtos = new Datos();
        
        if(objConexion!=null){
            try{
               PreparedStatement select = objConexion.prepareStatement("SELECT numero_tarjeta, dinero FROM tarjeta where cedula_jugador=?");
               select.setInt(1,cedula.getCedula_jugador());
               ResultSet rs = select.executeQuery();
               
               if(rs.next()){
                   dtos.setNumero_tarjeta(rs.getLong("numero_tarjeta"));
                   dtos.setDinero(rs.getInt("dinero"));
               }
            }catch(SQLException e){
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, "Error al obtener información de la tarjeta", e);
            }finally{
                conn.desConexion(objConexion);
            }
        }
        return dtos;
    }
   
    public Datos recargarTarjeta(Datos obj){
        ConexionBD conn = new ConexionBD();
        Connection objConexion = conn.obtenerConexionBaseDeDatos();
        int disponible=0;
        Long tarjeta = null;
        int saldo=0;
        Datos dtos = new Datos();
        
        if(objConexion!=null){
            try{
               PreparedStatement select = objConexion.prepareStatement("SELECT numero_tarjeta,dinero FROM tarjeta where cedula_jugador=?");
               select.setInt(1, obj.getCedula_jugador());
               ResultSet rs = select.executeQuery();
               if(rs.next()){
                   tarjeta=rs.getLong("numero_tarjeta");
                   saldo=rs.getInt("dinero");
               }
               
               PreparedStatement selectB = objConexion.prepareStatement("SELECT cupo_disp FROM banco WHERE numero_tarjeta= ?");
               selectB.setLong(1, tarjeta);
               ResultSet rsB = selectB.executeQuery();
               if(rsB.next()){
                   disponible = rsB.getInt("cupo_disp");
               }
               
               if(obj.getDinero()<=disponible){
                    saldo+=obj.getDinero();
                    PreparedStatement update = objConexion.prepareStatement("UPDATE tarjeta SET dinero=? WHERE numero_tarjeta=?");
                    update.setInt(1,saldo);
                    update.setLong(2,tarjeta);
                    update.executeUpdate();
                    update.close();
                  
                    int gasto = disponible-obj.getDinero();
                    PreparedStatement updateB = objConexion.prepareStatement("UPDATE banco SET cupo_disp=? WHERE numero_tarjeta=?");
                    updateB.setInt(1, gasto);
                    updateB.setLong(2, tarjeta);
                    updateB.executeUpdate();
                    updateB.close(); 
               }else{
                   dtos=null;
               }
               
            }catch(SQLException e){
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, "Error al obtener información de la tarjeta", e);
            }finally{
                conn.desConexion(objConexion);
            }
        }
        return dtos;
    }
}
