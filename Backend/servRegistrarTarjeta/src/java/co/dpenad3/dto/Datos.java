/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dto;


/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
public class Datos {
    
    long numero_tarjeta;
    int cedula_jugador;
    int cv;
    String fecha_ven;
    int dinero;

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
 
    public long getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(long numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }
    
     public int getCedula_jugador() {
        return cedula_jugador;
    }

    public void setCedula_jugador(int cedula_jugador) {
        this.cedula_jugador = cedula_jugador;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public String  getFecha_ven() {
        return fecha_ven;
    }

    public void setFecha_ven(String  fecha_ven) {
        this.fecha_ven = fecha_ven;
    }
    
}

//CREATE TABLE public.tarjeta
//(
//    cedula_jugador integer NOT NULL,
//    numero_tarjeta bigint NOT NULL,
//    dinero integer NOT NULL,
//    CONSTRAINT pk_cedulaj_numerot PRIMARY KEY (cedula_jugador, numero_tarjeta),
//    CONSTRAINT fk_cedula_jugador FOREIGN KEY (cedula_jugador)
//        REFERENCES public.jugador (cedula) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION,
//    CONSTRAINT fk_numero_tarjeta FOREIGN KEY (numero_tarjeta)
//        REFERENCES public.banco (numero_tarjeta) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//)
