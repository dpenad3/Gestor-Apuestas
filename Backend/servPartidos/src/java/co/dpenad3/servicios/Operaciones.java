/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.servicios;

import co.dpenad3.dao.ConApuestas;
import co.dpenad3.dao.Consulta;
import co.dpenad3.dto.Respuesta;
import co.dpenad3.dto.Apuesta;
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
    
    @Path("partidosfutbol")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta listaPartidosFutbol(){
        Respuesta r = new Respuesta();
        Consulta cons = new Consulta();
        r.setPartidos(cons.listaPartidosFutbol());
        if(r==null){
            r.setCodigo(Mensajes.COD_ERROR_NODATA);
            r.setMensajeE(Mensajes.MNS_ERROR_NODATA);
        }
        else{
          r.setCodigo(Mensajes.COD_EXITO);
          r.setMensajeE(Mensajes.MNS_EXITO_LISTA);
        }
        return r;
    }
    
    @Path("realizarapuesta")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta apuesta(Apuesta datos){
       Respuesta r = new Respuesta();
       ConApuestas cons = new ConApuestas();
       int x = cons.realizarApuesta(datos);
       if(x!=0){
           r.setCodigo(Mensajes.COD_EXITO);
           r.setMensajeE(Mensajes.MNS_EXITO_APUESTA);
       }
       else{
           r.setCodigo(Mensajes.COD_ERROR);
           r.setMensajeE(Mensajes.MNS_ERROR_APUESTA);
       }
       return r;
    }
}
