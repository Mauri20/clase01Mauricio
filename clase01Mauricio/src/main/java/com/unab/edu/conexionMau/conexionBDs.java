/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexionMau;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Stanly
 */
public class conexionBDs {
    
    
    private Connection conexion;
    
     public conexionBDs(){
     
         try {
             
          conexion = DriverManager.getConnection("jdbc:mysql://localhost/clase1","root","root");
             System.out.println("conectado a la bd");
         } catch (Exception e) {
             System.out.println("Eror de conexion"+e);
         }
         
     }
     
     public Connection retornarConexion(){
     return conexion;
     }
    
}
