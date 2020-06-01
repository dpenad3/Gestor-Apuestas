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
public interface Operaciones<T> {
    public List<T> consultar(String pk);
    public List<T> consultar(Long pk);
    public List<T> consultar();
    public int modificar(T dato);
    public int ingresar(T dato);
    public int eliminar(T dato);
    
}
