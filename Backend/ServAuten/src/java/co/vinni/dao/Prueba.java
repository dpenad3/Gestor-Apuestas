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
import co.vinni.dao.OperacionregistroIm1;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prueba {
    
      public static void main(String args[]){
        Operacion op = new Operacion();
        OperacionregistroIm1 opr = new OperacionregistroIm1();
        
//            System.out.println("Autenticacion");
//            System.out.println(op.login(1022440480,"Gustavo1"));
//            System.out.println("Registro");
////          System.out.println(opr.ingresar(1022440480,"gustavo","delgado","gustavito@hotmail.com","Gustavo2"));
//            System.out.println("Modificar");
            op.modificar(98765,"KAREN","ABADIA","KABAD@HOTMAIL.COM","KAREN1");
        
    }
      
    
}
