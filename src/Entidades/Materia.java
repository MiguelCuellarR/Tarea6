/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *Clase Materia con sus respectivos atributos y 
 * sus constructores.
 * Métodos get.
 * @author Lorena
 */
public class Materia {
    private int codigo;
    private String nombre;
    
    public Materia(int codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
}
