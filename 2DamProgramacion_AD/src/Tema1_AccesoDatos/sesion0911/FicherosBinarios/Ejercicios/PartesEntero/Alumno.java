package Tema1_AccesoDatos.sesion0911.FicherosBinarios.Ejercicios.PartesEntero;

import java.io.Serializable;

public class Alumno implements Serializable {
    // Atributos
    private String nombre;
    private int edad;
    private String curso;

    // Constructor parametrizado
    public Alumno(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // GETTER/SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Metodo toString()
    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", curso='" + curso + '\'' +
                '}';
    }
}
