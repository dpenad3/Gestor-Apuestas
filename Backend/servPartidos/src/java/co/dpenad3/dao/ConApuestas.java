/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dao;

import co.dpenad3.bd.ConexionBD;
import co.dpenad3.dto.Apuesta;
import co.dpenad3.interfaces.OperApuestas;
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
public class ConApuestas implements OperApuestas{

    public int realizarApuesta(Apuesta obj){
        
        ConexionBD conn = new ConexionBD();
        Connection objConexion = conn.obtenerConexionBaseDeDatos();
        int resInsert=0;
        
        if(objConexion!=null){
            try{
                int dinero=0;
                PreparedStatement select = objConexion.prepareStatement("SELECT dinero FROM tarjeta where cedula_jugador=?");
                select.setInt(1, obj.getId_jugador());
                ResultSet rs = select.executeQuery();
                if(rs.next()){
                    dinero=rs.getInt("dinero");
                }
                if(obj.getDinero()<=dinero){
                    PreparedStatement insert = objConexion.prepareStatement("INSERT INTO apuesta id_jugador, id_partido, dinero_apuesta, porcentaje_eleccion) VALUES (?, ?, ?, ?)");
                    insert.setInt(1, obj.getId_jugador());
                    insert.setInt(2, obj.getId_partido());
                    insert.setInt(3, obj.getDinero());
                    insert.setFloat(4, obj.getPorcentaje());
                    resInsert = insert.executeUpdate();
                    insert.close();
                }
                else{
                    System.out.println("No hay suficiente cantidad de dinero");
                }
            }
            catch(SQLException e){
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, "Error al realizar la apuesta", e);
            }finally{
                conn.desConexion(objConexion);
            }
        }
        return resInsert;
    }  
}
