/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.servicios;

import co.vinni.dao.Conexion;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author gusta
 */
public class Mensajes {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Mensajes.class);
       
    public static final int codigo_exito= 0;  
    public static final String mensaje_exito= "Consulta exitosa de dato.";
    
    public static final int codigo_error_bd= 10;  
    public static final String mensaje_error_bd= "Se genero un inconveniente al conectarse a la base de datos, intente nuevamente.";
 
    public static final int codigo_error_nodata= 20;  
    public static final String mensaje_error_nodata= "No se encuentra informacion de la consulta que desea hacer.";
}
