/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import Excepciones.ArchivoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *Se lee el archivo .txt
 * @author Lorena Naranjo
 */
public class LeerArchivo {
    //Se declara una lista para almacenar los datos que entran en el archivo.
    public ArrayList datos = new ArrayList<>();
    
    public ArrayList LeerArchivo(String ruta) throws ArchivoException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

      try {
         // Se abre el archivo y se crea el BufferedReader para poder
         // hacer una lectura comoda, es decir, que se lea línea por línea.
         archivo = new File (ruta);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del archivo
         String linea;
         while((linea=br.readLine())!=null)
            //System.out.println(linea);
            datos.add(linea);
      }
      catch(Exception e){
         throw new ArchivoException("No se encontró el archivo en la ruta");
      }finally{
         // Se finaliza el proceso de apertura del archivo.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return datos;
   }
}