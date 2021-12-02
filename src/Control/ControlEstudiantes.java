/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidades.Estudiante;
import Excepciones.ArchivoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase de Control de estudiantes con métodos para 
 * contar ls materias que tiene inscritas cada materia
 * según el archivo plano que se ingrese.
 * 
 * @author Lorena
 */
public class ControlEstudiantes {
    
    private List<Estudiante> estudiantes;
    
    public ControlEstudiantes(){
        this.estudiantes = new ArrayList<Estudiante>();
    }
    
    /**
     * Método donde se identifica el dato correspondiente
     * para imprimirlo en el mensaje.
     * @param archivo
     * @return un mensaje con el nombre del estudiante y el total
     * de materias inscritas.
     * @throws FileNotFoundException
     * @throws ArchivoException 
     */
    
    public String materiasPorEstudiante(File archivo) throws 
            FileNotFoundException, ArchivoException{
        if(archivo == null){
            throw new ArchivoException("El archivo es nulo.");
        }
        
        String mensaje = "";
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
        Set<String> cedulasRevisadas = new HashSet<String>();
        
        
        try {
            String linea = br.readLine();
            
            while(linea != null) {
                String[] partes = linea.split(",");
                if (!cedulasRevisadas.contains(partes[0])){
                    int incidencias = this.buscarCedula(partes[0], archivo);
                    mensaje += partes[1] + " " + incidencias + " Materias\n";
                    
                    cedulasRevisadas.add(partes[0]);
                    
                    Estudiante estudiante = new Estudiante(partes[0], partes[1]);
                    estudiantes.add(estudiante);
                    
                }
                linea = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
    
    /**
     * Método buscar un estudiantes por su cédula 
     * recorriendo los elementos del archivo plano
     * @param cedula
     * @param archivo
     * @return total de incidencias de la cédula del estudiante.
     */
    public static int buscarCedula(String cedula, File archivo) {
        int totalIncidencias = 0;
        try {
            if (archivo.exists()) {

                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                
                while ((lineaLeida = archivoLeer.readLine()) != null) {

                    String[] partes = lineaLeida.split(",");

                    for (int i = 0; i < partes.length; i++) {
                        if (partes[i].equals(cedula)) {
                            totalIncidencias = totalIncidencias + 1;
                            
                        }
                    }
                }
                archivoLeer.close();
            }           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return totalIncidencias;
    }
}