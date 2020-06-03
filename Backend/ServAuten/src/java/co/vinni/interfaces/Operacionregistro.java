/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.interfaces;

import co.vinni.dto.Registrodatos;
import java.util.List;

/**
 *
 * @author gusta
 */
public interface Operacionregistro {
    public List<Registrodatos> consultar(String pk);
    public List<Registrodatos> consultar();
    public int modificar(Registrodatos dato);
    public int ingresar(Registrodatos dato);
    public int eliminar(Registrodatos dato);
            
    
}
