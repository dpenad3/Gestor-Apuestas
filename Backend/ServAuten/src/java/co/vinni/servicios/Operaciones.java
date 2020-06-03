package co.vinni.servicios;

import co.vinni.dao.Consultas;
import co.vinni.dao.Operacion;
import co.vinni.dto.Datos;
import co.vinni.dto.Respuesta;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Vinni
 */
@Path("operacion")
public class Operaciones {
    private static final Logger LOG = LogManager.getLogger(Operaciones.class);
    
    /*@Path("version")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String version(){
        return "version 1.0";
    }
    
    @Path("autenticar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public Respuesta autenticar(Datos datos){
        Respuesta r = new Respuesta();
        r.setCodigo(1);
        r.setMensajeE("Existe");
        
        Consultas cons = new Consultas();
        Datos d = cons.consulta(datos);
        
        if (d == null){
            r.setCodigo(0);
            r.setMensajeE("No Existe");
        }
        
        r.setInfo(d);
        return r;
    }*/
    
    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Respuesta login(Datos datos) {
        Respuesta r = new Respuesta();
        try {
            Operacion obj = new Operacion();
            //  Datos d = cons.consulta(datos);

            if (datos.getCedula() == 0 || datos.getContrasena() == null) {
                LOG.debug("Conexion");
                r.setCedula(0);
                r.setContrasena("GUSTAVO1");
                r.setMensajeE("Valores no validos");
            } else {
                if (obj.login(datos.getCedula(), datos.getContrasena())) {
                    r.setCodigo(1);
                    LOG.debug("Los valores si son validos para la conexion");
                    r.setCedula(datos.getCedula());
                    r.setContrasena(datos.getContrasena());
                    r.setMensajeE("Valores validos");
                } else {
                    LOG.debug("No encontro valores para la conexion");
                    r.setCedula(datos.getCedula());
                    r.setContrasena(datos.getContrasena());
                    r.setMensajeE("Valores no validos");
                }
            }
            return r;
        } catch (SQLException e) {
            LOG.debug("cath de la conexion");
            e.getStackTrace();
        }
        return null;

    }    
    
}
