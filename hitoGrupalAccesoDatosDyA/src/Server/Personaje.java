package Server;

import java.io.Serializable;
import java.util.Scanner;

public class Personaje implements Serializable {
    private static final long serialVersionUID = 4854486451470258537L;
    //Atributos de personajes
    public String funcion;
    public String nombre;
    public int edad;


    //Getter y Setter
    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //toString()
    @Override
    public String toString() {
        return "Personaje{" +
                "funcion='" + funcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
