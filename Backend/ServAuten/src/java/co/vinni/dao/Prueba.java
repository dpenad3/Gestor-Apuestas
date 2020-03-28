/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dao;

/**
 *
 * @author gusta
 */
import co.vinni.dao.Operacion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {
    
      public static void main(String args[]){
        Operacion op=new Operacion();
        try {
            System.out.println(op.login(1022440480,"Gustavo1"));
        } catch (SQLException ex) {
            System.out.println("soy un error joder...");
        }
    }
      
    
}
