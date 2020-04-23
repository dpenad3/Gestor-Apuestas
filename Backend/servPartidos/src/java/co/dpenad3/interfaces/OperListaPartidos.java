/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dpenad3.interfaces;

import co.dpenad3.dto.Partido;
import java.util.ArrayList;

/**
 *
 * @author dani2
 */
public interface OperListaPartidos {
    
    public ArrayList<Partido> listaPartidosFutbol();
    public ArrayList<Partido> porPartidoFutbol(int id);
}
