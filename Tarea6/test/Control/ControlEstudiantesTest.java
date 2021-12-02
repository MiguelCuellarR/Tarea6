/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MIGUEL_ANGEL
 */
public class ControlEstudiantesTest {
    
    public ControlEstudiantesTest() {
    }

    
    /**
     * Test para comprobar que se cuenta correctamente las veces en que se 
     * encuentra una cédula en un archivo.
     * @throws Exception 
     */
    @Test
    public void buscarCedulaCorrecta() throws Exception {
        File file = new File 
            ("C:\\Users\\HOGAR\\Documents\\Ingenieria de Software 1\\Prueba.txt");
        ControlEstudiantes ctrlEstudiantes = new ControlEstudiantes();
        int msjActual = ctrlEstudiantes.buscarCedula("1234567", file);
        
        assertEquals(2, msjActual);
    }
     
    
    /**
     * Test para comprobar que cuando la cédula no existe simplemente devolvera
     * un 0.
     * @throws Exception 
     */
    @Test
    public void buscarCedulaIncorrecta() throws Exception {
        File file = new File 
            ("C:\\Users\\HOGAR\\Documents\\Ingenieria de Software 1\\Prueba.txt");
        ControlEstudiantes ctrlEstudiantes = new ControlEstudiantes();
        int msjActual = ctrlEstudiantes.buscarCedula("18458414", file);
        
        assertEquals(0, msjActual);
    }

    
    
}
