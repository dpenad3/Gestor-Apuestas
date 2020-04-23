/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dao;

import co.dpenad3.bd.ConexionBD;
import co.dpenad3.dto.Partido;
import co.dpenad3.interfaces.OperListaPartidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
public class Consulta implements OperListaPartidos{

    public ArrayList<Partido> listaPartidosFutbol() {
        
        ConexionBD conn = new ConexionBD();
        Connection objConexion = conn.obtenerConexionBaseDeDatos();
        ArrayList<Partido> partidos = new ArrayList();
        
        if(objConexion!=null){
            try{
                PreparedStatement select = objConexion.prepareStatement("SELECT id, fecha, id_local, id_visitante, puntos_local, puntos_visitante, porcentaje_local, porcentaje_visitante, porcentaje_empate FROM partido where deporte=?");
                select.setString(1,"futbol");
                ResultSet rs = select.executeQuery();
                while(rs.next()){
                    Partido p = new Partido();
                    p.setId(rs.getInt("id"));
                    p.setFecha(rs.getDate("fecha"));
                    p.setPuntos_local(rs.getInt("puntos_local"));
                    p.setPuntos_visitante(rs.getInt("puntos_visitante"));
                    p.setPorcentaje_local(rs.getFloat("porcentaje_local"));
                    p.setPorcentaje_visitante(rs.getFloat("porcentaje_visitante"));
                    p.setPorcentaje_empate(rs.getFloat("porcentaje_empate"));
                    PreparedStatement local = objConexion.prepareStatement("SELECT nombre FROM equipo where id=?");
                    local.setInt(1, rs.getInt("id_local"));
                    ResultSet lc = local.executeQuery();
                    if(lc.next()){
                        p.setLocal(lc.getString("nombre"));
                    }   
                    PreparedStatement visitante = objConexion.prepareStatement("SELECT nombre FROM equipo where id=?");
                    visitante.setInt(1, rs.getInt("id_visitante"));
                    ResultSet vs = visitante.executeQuery();
                    if(vs.next()){
                       p.setVisitante(vs.getString("nombre")); 
                    }
                    partidos.add(p);
                }
            }catch(SQLException e){
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, "Error al obtener lista de partidos", e);
            }finally{
                conn.desConexion(objConexion);
            }
        }
        return partidos;
    }

    
    public ArrayList<Partido> porPartidoFutbol(int id) {
        return null;
    }
    
}
