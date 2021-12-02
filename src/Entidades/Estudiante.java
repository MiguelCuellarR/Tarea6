/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *Clase Estudiante con sus respectivos atributos
 * y constructores.
 * Métodos get.
 * 
 * @author Lorena
 */
public class Estudiante {
    
    private String cedula;
    private String nombre;
    private List<Materia> materias;

    public Estudiante(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.materias = new ArrayList<Materia>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
}
