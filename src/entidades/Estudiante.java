package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author MIGUEL_ANGEL
 */
public class Estudiante {
    
    private String cedula;
    private String nombre;
    private List<Materia> materias;
    
    public Estudiante (String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        materias = new ArrayList<Materia>();
    }
}
