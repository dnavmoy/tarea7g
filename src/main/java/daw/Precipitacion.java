/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;


/**
 *
 * @author daniel
 */

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"fecha",
"estacionMeteorologica",
"provincia",
"precipitacion"
})

public class Precipitacion {

@JsonProperty("fecha")
private LocalDate fecha ;
@JsonProperty("estacionMeteorologica")
private String estacionMeteorologica;
@JsonProperty("provincia")
private String provincia;
@JsonProperty("precipitacion")
private Double precipitacion;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public Precipitacion() {
}

/**
*
* @param fecha
* @param estacionMeteorologica
* @param provincia
* @param precipitacion
*/
public Precipitacion(LocalDate fecha, String estacionMeteorologica, String provincia, Double precipitacion) {
super();
this.fecha = fecha;
this.estacionMeteorologica = estacionMeteorologica;
this.provincia = provincia;
this.precipitacion = precipitacion;
}

@JsonProperty("fecha")
public LocalDate getFecha() {
return fecha;
}

@JsonProperty("fecha")
public void setFecha(LocalDate fecha) {
this.fecha = fecha;
}

@JsonProperty("estacionMeteorologica")
public String getEstacionMeteorologica() {
return estacionMeteorologica;
}

@JsonProperty("estacionMeteorologica")
public void setEstacionMeteorologica(String estacionMeteorologica) {
this.estacionMeteorologica = estacionMeteorologica;
}

@JsonProperty("provincia")
public String getProvincia() {
return provincia;
}

@JsonProperty("provincia")
public void setProvincia(String provincia) {
this.provincia = provincia;
}

@JsonProperty("precipitacion")
public Double getPrecipitacion() {
return precipitacion;
}

@JsonProperty("precipitacion")
public void setPrecipitacion(Double precipitacion) {
this.precipitacion = precipitacion;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(Precipitacion.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("fecha");
sb.append('=');
sb.append(((this.fecha == null)?"<null>":this.fecha));
sb.append(',');
sb.append("estacionMeteorologica");
sb.append('=');
sb.append(((this.estacionMeteorologica == null)?"<null>":this.estacionMeteorologica));
sb.append(',');
sb.append("provincia");
sb.append('=');
sb.append(((this.provincia == null)?"<null>":this.provincia));
sb.append(',');
sb.append("precipitacion");
sb.append('=');
sb.append(((this.precipitacion == null)?"<null>":this.precipitacion));
sb.append(',');
sb.append("additionalProperties");
sb.append('=');
sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

@Override
public int hashCode() {
int result = 1;
result = ((result* 31)+((this.fecha == null)? 0 :this.fecha.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
result = ((result* 31)+((this.provincia == null)? 0 :this.provincia.hashCode()));
result = ((result* 31)+((this.estacionMeteorologica == null)? 0 :this.estacionMeteorologica.hashCode()));
result = ((result* 31)+((this.precipitacion == null)? 0 :this.precipitacion.hashCode()));
return result;
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof Precipitacion) == false) {
return false;
}
Precipitacion rhs = ((Precipitacion) other);
return ((((((this.fecha == rhs.fecha)||((this.fecha!= null)&&this.fecha.equals(rhs.fecha)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.provincia == rhs.provincia)||((this.provincia!= null)&&this.provincia.equals(rhs.provincia))))&&((this.estacionMeteorologica == rhs.estacionMeteorologica)||((this.estacionMeteorologica!= null)&&this.estacionMeteorologica.equals(rhs.estacionMeteorologica))))&&((this.precipitacion == rhs.precipitacion)||((this.precipitacion!= null)&&this.precipitacion.equals(rhs.precipitacion))));
}

}
