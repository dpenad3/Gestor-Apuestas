/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dao;

import co.vinni.dto.Registrodatos;
import co.vinni.interfaces.Operaciones;
import co.vinni.servicios.Servregistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author gusta
 */
public class OperacionregistroIm1 implements Operaciones<Registrodatos> {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Servregistro.class);

    public List<Registrodatos> consultar(String pk) {
        return null;
    }

    @Override
    public List<Registrodatos> consultar(Long pk) {
        return consultar(pk.toString());
    }

    public List<Registrodatos> consultar() {

        Conexion con = new Conexion();
        Connection cx = con.conectarse();
        List<Registrodatos> datos = new ArrayList<Registrodatos>();

        if (cx != null) {
            try {
                PreparedStatement ps = cx.prepareStatement("select * from public.registros");

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int cedula = rs.getInt("cedula");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String correo = rs.getString("correo");

                    Registrodatos r = new Registrodatos();
                    r.setCedula(cedula);
                    r.setNombre(nombre);
                    r.setApellido(apellido);
                    r.setCorreo(correo);
                    r.setContrasena(rs.getString("contrasena"));

                    datos.add(r);

                }
                return datos;
            } catch (SQLException ex) {
                Logger.getLogger(OperacionregistroIm.class.getName()).log(Level.SEVERE, "Error en consultar registros", ex);
            }
        }
        return datos;
    }

//    public int modificar(Registrodatos dato) {
//        Conexion con = new Conexion();
//        Connection cx = con.conectarse();
//        if (cx != null) {
//            try {
//                PreparedStatement ps = cx.prepareStatement("UPDATE public.registros "
//                        + "	SET  nombre=?, apellido=?, correo=?, contrasena=?\n"
//                        + "	WHERE cedula = ?");
//                ps.setInt(1,dato.getCedula());
//                ps.setString(2, dato.getNombre());
//                ps.setString(3, dato.getApellido());
//                ps.setString(4, dato.getCorreo());
//                ps.setString(5, dato.getContrasena());
//                
//                int rta= ps.executeUpdate();
//                con.desconectarse(cx);
//                return rta;
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(OperacionregistroIm1.class.getName()).log(Level.SEVERE, null, ex);
//            } finally{
//                con.desconectarse(cx);
//            }
//        }
//
//        return 0;
//    }
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


    @Override
    public int eliminar(Registrodatos dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Registrodatos dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//    public int ingresar(Registrodatos dato) {
//        Conexion con = new Conexion();
//        Connection cx = con.conectarse();
//        if (cx != null) {
//            try {
//                PreparedStatement ps = cx.prepareStatement("INSERT INTO public.registros(cedula, nombre, apellido, correo, contrasena)VALUES (?, ?, ?, ?, ?)");
//                ps.setInt(1, dato.getCedula());
//                ps.setString(2, dato.getNombre());
//                ps.setString(3, dato.getApellido());
//                ps.setString(4, dato.getCorreo());
//                ps.setString(5, dato.getContrasena());
//
//                int rta = ps.executeUpdate();
//                con.desconectarse(cx);
//                return rta;
//
//            } catch (SQLException ex) {
//                Logger.getLogger(OperacionregistroIm.class.getName()).log(Level.SEVERE, "Error en insercion de registros", ex);
//            } finally {
//                con.desconectarse(cx);
//            }
//        }
//        return 0;
//    }
//
//    public int eliminar(Registrodatos dato) {
//        return 0;
//    }

//    public static void main(String[] args) {
//        OperacionregistroIm oper = new OperacionregistroIm();
////        Registrodatos rd = new Registrodatos();
////        rd.setCedula(1234567891);
////        rd.setNombre("Olga");
////        rd.setApellido("Guzman");
////        rd.setCorreo("olgaguzman@gmail.com");
////        rd.setContrasena("Olga1");
////        int x = oper.ingresar(rd);
////        System.out.println("respuesta"+x);
//        List<Registrodatos> lista = oper.consultar();
//        System.out.println("Lista"+lista);
//        if(lista.size() > 0){
//            System.out.println("Si hay datos en la base de datos");
//            for (Registrodatos registrodatos : lista){
//                System.out.println("Registrodatos"+registrodatos);
//            }
//        }
//    }

