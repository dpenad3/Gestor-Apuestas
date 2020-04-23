/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.servicios;

import co.dpenad3.dao.Consultas;
import co.dpenad3.dto.Datos;
import co.dpenad3.dto.Respuesta;
import co.dpenad3.utility.Mensajes;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
@Path("operacion")
public class Operaciones {
    
    
    @Path("version")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String version(){
        return "version 1.0";
    }
    
    @Path("registrarTarjeta")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registarTarjeta(Datos datos)
    {
       Respuesta r = new Respuesta();
        r.setCodigo(Mensajes.COD_EXITO);
        r.setMensajeE(Mensajes.MNS_EXITO_REGISTRO);
        
        Consultas cons = new Consultas();
        Datos d = cons.registrarTarjeta(datos);
        
        if (d == null){
            r.setCodigo(Mensajes.COD_ERROR);
            r.setMensajeE(Mensajes.MNS_ERROR_REGISTRO);
        }
        
        r.setInfo(d);
        return r;
     
    }
    
    @Path("darTarjeta")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta darTarjeta(Datos cedula)
    {
        Respuesta r = new Respuesta();
        r.setCodigo(Mensajes.COD_EXITO);
        r.setMensajeE(Mensajes.MNS_EXITO_OBTENER);
        
        Consultas cons = new Consultas();
        Datos d = cons.darTarjeta(cedula);
        
        if (d == null){
            r.setCodigo(Mensajes.COD_ERROR);
            r.setMensajeE(Mensajes.MNS_ERROR_OBTENER);
        }
        
        r.setInfo(d);
        return r;
     
    }
}
