/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Dao;

import com.unab.edu.conexionMau.conexionBDs;
import com.unab.edu.entidades.persona;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Stanly
 */
public class ClsPersonas {
    
    
     conexionBDs claseconectar = new conexionBDs();
        Connection conectar = (Connection) claseconectar.retornarConexion();

    public ArrayList<persona> MostrarPersona() {
        ArrayList<persona> Personas = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_s_Persona()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();

            while (resultadoDeConsulta.next()) {

                persona Persona = new persona();
                Persona.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                Persona.setNombre(resultadoDeConsulta.getString("Nombre"));
                Persona.setApellido(resultadoDeConsulta.getString("Apellido"));
                Persona.setEdad(resultadoDeConsulta.getInt("Edad"));
                Persona.setSexo(resultadoDeConsulta.getString("sexo"));

                Personas.add(Persona);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return Personas;
    }

    public void AgregarPersona(persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_Persona(?,?,?,?)");

            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, " Persona guardada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void BorrarPersona(persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_Persona(?)");
            Statement.setInt("PIdPersonas", Per.getIdPersona());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Persona Eliminada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ActualizarPersona(persona Persona) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_Persona(?,?,?,?,?)");
            Statement.setInt("PIdPersonas", Persona.getIdPersona());
            Statement.setString("PNombre", Persona.getNombre());
            Statement.setString("PApellido", Persona.getApellido());
            Statement.setInt("PEdad", Persona.getEdad());
            Statement.setString("PSexo", Persona.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, " Persona Actualizada Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
}
