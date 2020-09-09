/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Dao;

import com.unab.edu.conexionMau.conexionBDs;
import com.unab.edu.entidades.Estudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Stanly
 */
public class ClsJoinPersonaEstudiante {
    
    
    
     
    conexionBDs cn = new conexionBDs();
    Connection con = cn.retornarConexion();
    
    public ArrayList <Estudiante>MostrarJoinEstudiantePersona(){
    ArrayList <Estudiante> lista = new ArrayList<>();
    
        try {
            CallableStatement st = con.prepareCall("call Sp_s_Joinmostrarpersonaestudiante()");
            
            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
            Estudiante es = new Estudiante();
            es.setNombre(rs.getString("nombre"));
            es.setApellido(rs.getString("apellido"));
            es.setMatricula(rs.getInt("matricula"));
            
            lista.add(es);
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error aqui"+e);
        }
        return lista;
    
    
    }
    
}
