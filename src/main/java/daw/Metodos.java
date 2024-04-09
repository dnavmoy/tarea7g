/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author daniel
 */
public class Metodos {

    public static ArrayList<Precipitacion> leerJson(String ruta) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        ArrayList<Precipitacion> catalogo = mapeador.readValue(new File(ruta),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Precipitacion.class));

        return catalogo;
    }

    public static void escribirJson(String ruta, Map<String, Double> mapa) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(ruta), mapa);

        // Escribe en un fichero JSON el catálogo de envíos
        mapeador.writeValue(new File(ruta), mapa);
    }
}


