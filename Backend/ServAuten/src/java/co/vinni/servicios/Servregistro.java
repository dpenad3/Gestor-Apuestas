/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.servicios;

import co.vinni.dao.OperacionregistroIm;
import co.vinni.dao.OperacionregistroIm1;
import co.vinni.dto.Registrodatos;
import co.vinni.dto.Respuesta;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author gusta
 */
@Path("serviciosregistro")
public class Servregistro {

    private static final Logger LOG = LogManager.getLogger(Servregistro.class);

    @Path("consultaT")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta consultarT() {
        LOG.info("CONEXION-Consulta todo");
        LOG.debug("Clase servregistro para la consulta de registros del usuario");
        Respuesta r = new Respuesta();
        r.setCodigo(Mensajes.codigo_exito);
        r.setMensajeE(Mensajes.mensaje_exito);
        LOG.debug("Mensaje de exito para la consulta de registros del usuario");
        //OperacionregistroIm oper = new OperacionregistroIm();
        OperacionregistroIm1 oper = new OperacionregistroIm1();
        List<Registrodatos> lista = oper.consultar();
        r.setRegistrodatos(lista);
        LOG.debug("Trajo la lista de la consulta de registros del usuario");
        return r;
    }

    @Path("consultarXcedula")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta consultarXcedula() {
        LOG.info("CONEXION-Consulta por cedula");
        LOG.debug("Clase servregistro para la consulta de registros del usuario por cedula");
        Respuesta r = new Respuesta();
        r.setCodigo(Mensajes.codigo_exito);
        r.setMensajeE(Mensajes.mensaje_exito);
        LOG.debug("Mensaje de exito para la consulta de registro del usuario por cedula");
        return r;
    }

    @Path("modificarregistro")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
        public Respuesta modificar(Registrodatos datos) throws SQLException{
        System.out.println(datos);
        Respuesta r = new Respuesta();
        OperacionregistroIm1 obj = new OperacionregistroIm1();
        //  Datos d = cons.consulta(datos);
        if (datos.getCedula()== 0 || datos.getNombre()== null || datos.getApellido()== null || datos.getCorreo()== null || datos.getContrasena()==null ){
            r.setCodigo(10);
            r.setMensajeE("Valores no validos");
        }else{
            if(obj.modificar(datos.getCedula(),datos.getNombre(),datos.getApellido(),datos.getCorreo(),datos.getContrasena())){
                r.setCodigo(0);
                r.setMensajeE("Valores validos");
            } 
        }
        return r;
         
    }
//    public Respuesta modificar(Registrodatos dato) throws SQLException{
//        Respuesta r = new Respuesta();
//        LOG.info("CONEXION-Modificacion de registros");
//        LOG.debug("Clase servregistro para la modficicion de registros del usuario");
//        r.setCodigo(Mensajes.codigo_exito);
//        r.setMensajeE(Mensajes.mensaje_exito);
//        LOG.debug("Mensaje de exito para la modificacion de datos de registro del usuario");
//        OperacionregistroIm1 oper = new OperacionregistroIm1();
//        oper.modificar(dato);
//        LOG.debug("Logro la modificacion de registros del usuario");
//        return r;
//    }

    @Path("ingresarregistro")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta ingresar(Registrodatos dato) {
        Respuesta r = new Respuesta();
        LOG.info("CONEXION-ingreso de registros");
        LOG.debug("Clase servregistro para el ingreso de registros del usuario");
        r.setCodigo(Mensajes.codigo_exito);
        r.setMensajeE(Mensajes.mensaje_exito);
        LOG.debug("Mensaje de exito para el ingreso de datos de registro del usuario");
        OperacionregistroIm1 oper = new OperacionregistroIm1();
        oper.ingresar(dato);
        LOG.debug("Logro el ingreso de registros del usuario");
        return r;
    }

    @Path("eliminarregistro")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta eliminar(Registrodatos dato) {
        Respuesta r = new Respuesta();
        r.setCodigo(Mensajes.codigo_exito);
        r.setMensajeE(Mensajes.mensaje_exito);
        return r;
    }

}
