/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.utility;

/**
 *
 * @author dani2
 */
public class Mensajes {
    
    public static final int COD_EXITO=0;
    public static final String MNS_EXITO_REGISTRO="Tarjeta registrada correctamente";
    public static final String MNS_EXITO_OBTENER="Info de tarjeta enviada correctamente";
    
    public static final int COD_ERROR=-1;
    public static final String MNS_ERROR_REGISTRO="Error al registrar la tarjeta";
    public static final String MNS_ERROR_OBTENER="Error al tener información de la tarjeta";
    
    public static final int COD_ERROR_BD=500;
    public static final String MNS_ERROR_BD="Error al conectarse a la base de datos";
    
    public static final int COD_ERROR_NODATA=510;
    public static final String MNS_ERROR_NODATA="No se encuentra la información requerida";
}
