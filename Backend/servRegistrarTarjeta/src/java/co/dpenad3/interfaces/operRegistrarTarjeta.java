/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.interfaces;

import co.dpenad3.dto.Datos;

/**
 *
 * @author Daniela Ivonne Peña Duarte
 */
public interface operRegistrarTarjeta {
    
    public Datos registrarTarjeta(Datos obj);
    public Datos darTarjeta(Datos cedula);
}
