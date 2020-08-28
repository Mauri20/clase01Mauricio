/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import lombok.*;

/**
 *
 * @author Stanly
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Estudiante extends persona{
    
     private int Id  ;
    private int matricula;
    
}
