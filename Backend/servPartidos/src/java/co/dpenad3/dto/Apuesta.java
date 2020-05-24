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
public class Apuesta {
    
    int cedula_jugador;
    int id_partido;
    int dinero;
    float porcentaje;
    int id_equipo;

    public int getId_jugador() {
        return cedula_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.cedula_jugador = id_jugador;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getCedula_jugador() {
        return cedula_jugador;
    }

    public void setCedula_jugador(int cedula_jugador) {
        this.cedula_jugador = cedula_jugador;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    
}

//CREATE TABLE public.apuesta
//(
//    id_jugador integer NOT NULL,
//    id_partido integer NOT NULL,
//    dinero_apuesta integer NOT NULL,
//    porcentaje_eleccion numeric NOT NULL,
//    id_equipo integer NOT NULL,
//    CONSTRAINT apuesta_pkey PRIMARY KEY (id_jugador, id_partido),
//    CONSTRAINT id_jugador FOREIGN KEY (id_jugador)
//        REFERENCES public.jugador (cedula) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//        NOT VALID,
//    CONSTRAINT id_partido FOREIGN KEY (id_partido)
//        REFERENCES public.partido (id) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//        NOT VALID
//)