/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.dto;

import java.sql.Date;

/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
public class Partido {
    
    int id;
    Date fecha;
    String local;
    String visitante;
    int puntos_local;
    int puntos_visitante;
    float porcentaje_local;
    float porcentaje_visitante;
    float porcentaje_empate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public int getPuntos_local() {
        return puntos_local;
    }

    public void setPuntos_local(int puntos_local) {
        this.puntos_local = puntos_local;
    }

    public int getPuntos_visitante() {
        return puntos_visitante;
    }

    public void setPuntos_visitante(int puntos_visitante) {
        this.puntos_visitante = puntos_visitante;
    }

    public float getPorcentaje_local() {
        return porcentaje_local;
    }

    public void setPorcentaje_local(float porcentaje_local) {
        this.porcentaje_local = porcentaje_local;
    }

    public float getPorcentaje_visitante() {
        return porcentaje_visitante;
    }

    public void setPorcentaje_visitante(float porcentaje_visitante) {
        this.porcentaje_visitante = porcentaje_visitante;
    }

    public float getPorcentaje_empate() {
        return porcentaje_empate;
    }

    public void setPorcentaje_empate(float porcentaje_empate) {
        this.porcentaje_empate = porcentaje_empate;
    }
    
}

//CREATE TABLE public.partido
//(
//    id integer NOT NULL,
//    fecha date NOT NULL,
//    deporte character varying COLLATE pg_catalog."default" NOT NULL,
//    id_local integer NOT NULL,
//    id_visitante integer NOT NULL,
//    puntos_local integer,
//    puntos_visitante integer,
//    porcentaje_local numeric NOT NULL,
//    porcentaje_visitante numeric NOT NULL,
//    porcentaje_empate numeric NOT NULL,
//    CONSTRAINT partido_pkey PRIMARY KEY (id),
//    CONSTRAINT id_local FOREIGN KEY (id_local)
//        REFERENCES public.equipo (id) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//        NOT VALID,
//    CONSTRAINT id_visitante FOREIGN KEY (id_visitante)
//        REFERENCES public.equipo (id) MATCH SIMPLE
//        ON UPDATE NO ACTION
//        ON DELETE NO ACTION
//        NOT VALID
//)
