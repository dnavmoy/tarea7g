/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class Tarea7g {

    public static void main(String[] args) {
        
        // Construimos la ventana
	JFrame ventanaPrincipal = new JFrame ("Aplicación");

	// Establecemos posición y tamaño
	ventanaPrincipal.setBounds(250, 250, 800, 600);

	// Hacemos visible la ventana
	ventanaPrincipal.setVisible(true);

// Acción por defecto al pulsar el botón de cierre 	 ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
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
        
        
        //Guarda en un fichero JSON, en la raíz del proyecto, el resultado del 
        //map. Pasa el objeto map directamente a la hora de generar el archivo.
        
        
        try{
            Metodos.escribirJson("mapa.json", mapPrepAcumulada);
        }catch(IOException ioe){
            System.out.println("error escribiendo fichero");
        }
        
        //sando API Stream, muestra por consola el registro que tiene la mayor precipitación.
        System.out.println("mayor precipitacion: " + 
                lista.stream()
                .mapToDouble(p-> p.getPrecipitacion())
                .max()
        );
        
        
        //necesitamos el registro
        System.out.println("mayor precipitacion: " + 
                lista.stream()
                 .max(Comparator.comparingDouble(p-> p.getPrecipitacion()))
                        .get().toString());
                
                
        
        
        //Usando API Stream, muestra por consola el número de estaciones 
        //meteorológicas que han sido leídas entre el 10 de octubre de 2017 y el
        //20 de octubre de 2017, ambos días incluidos.
        
        System.out.println(" numero de estaciones entre 10-102017 y 20-10-2017:  " +
        lista.stream()
                .filter(p -> p.getFecha().isBefore(LocalDate.of(2017, 10, 21)))
                .filter(p-> p.getFecha().isAfter(LocalDate.of(2017,10, 9)))
                //.forEach(p -> System.out.println(p));
                .count()
        );
                
        //Usando API Stream, calcula la media de precipitaciones de aquellas 
        //estaciones meteorológicas leídas entre el 10 de octubre de 2017 y el 
        //20 de octubre de 2017, ambos días incluidos.
        
        double media= lista.stream()
                .filter(p -> p.getFecha().isBefore(LocalDate.of(2017, 10, 21)))
                .filter(p-> p.getFecha().isAfter(LocalDate.of(2017,10, 9)))
                .mapToDouble(p -> p.getPrecipitacion())
                .average()
                .getAsDouble();
        
        System.out.println("media precipitacion : %.2f".formatted(media));
                
        
    }
}
