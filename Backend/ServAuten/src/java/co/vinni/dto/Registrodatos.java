/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dto;

import co.vinni.dao.Operacion;
import java.sql.SQLException;

/**
 *
 * @author gusta
 */
public class Registrodatos {
    private int cedula; //pk
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    public Registrodatos() {
    }

    public Registrodatos(int cedula, String nombre, String apellido, String correo, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "cedula:" +this.cedula + "nombre:" + this.nombre + "apellido:" + this.apellido + "correo:" + this.correo + "contrasena:" + this.contrasena; 
    }
    
    public boolean modificar(int cedula, String nombre, String apellido, String correo, String contrasena) {
        Operacion dao = new Operacion();
        return dao.modificar(cedula, nombre, apellido, correo, contrasena);
    }
    
}
/**
 * CREATE TABLE public.registros
(
    cedula numeric(12) NOT NULL,
    nombre text,
    apellido text,
    correo text,
    contrasena text,
    CONSTRAINT pk_registro PRIMARY KEY (cedula)
);

ALTER TABLE public.registros
    OWNER to demo;
 */