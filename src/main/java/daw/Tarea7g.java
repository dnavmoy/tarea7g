/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author daniel
 */
public class Tarea7g {

    public static void main(String[] args) {
         ArrayList<Precipitacion> lista = new ArrayList<>();
        
         
         //Crea la clase POJO para mapear los datos del JSON en ella. Ayúdate de
         //la herramienta online vista en clase.
        try{
            lista=Metodos.leerJson("precipitacionesBadajoz.json");
        }catch (IOException ioe){
            System.out.println("error leyendo fichero");
        }
        
        
        //Procede a leer el fichero adjunto, carga los datos en una lista de 
        //objetos POJO y a muestra los registros contenidos la lista usando la consola.
        
        System.out.println("---- Catálogo de Precipitaciones ----");
        for (Precipitacion prep : lista) {
            System.out.println(prep);
        }
       
    //Obtén una estructura Map donde para cada nombre de estación meteorológica 
    //se pueda consultar la precipitación acumulada de la misma. Muestra por 
    //consola el resultado de la estructura map obtenida. Opcional, hacerlo con 
    //API Stream. 
        
        
        Map<String,Double> mapPrepAcumulada= new HashMap<>();
        //lista.stream()
        //        .forEach(v-> mapPrepAcumulada.put(v.getEstacionMeteorologica(), v.getPrecipitacion()));
        mapPrepAcumulada= lista.stream()
                .collect(Collectors.toMap(Precipitacion::getEstacionMeteorologica, Precipitacion::getPrecipitacion));
        System.out.println(mapPrepAcumulada.toString());
        
        
        
        
    }
}
