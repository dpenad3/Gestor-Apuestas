/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dto;

import java.util.List;

/**
 *
 * @author gusta
 */
public class Respuesta {
   
    private int cedula;    
    private String nombre;
    private String apellido;
    private String contrasena;
    private String mensajeE;
    private List<Registrodatos> registrodatos;
    private int codigo;

    public Respuesta() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMensajeE() {
        return mensajeE;
    }

    public void setMensajeE(String mensajeE) {
        this.mensajeE = mensajeE;
    }

    public List<Registrodatos> getRegistrodatos() {
        return registrodatos;
    }

    public void setRegistrodatos(List<Registrodatos> registrodatos) {
        this.registrodatos = registrodatos;
    }
    
  
}
