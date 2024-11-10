package Tema1_AccesoDatos.sesion0911.FicherosBinarios.Ejemplos.ejemploLecturaEscrituraArchivosBinarios_objetos;

import java.io.Serializable;

class Alumno implements Serializable {  // La clase debe implementar Serializable para poder ser escrita en un archivo binario

    // Atributos
    private String nombre;
    private int edad;
    private double notaMedia;

    // Constructor parametrizado
    public Alumno(String nombre, int edad, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    // Métodos getter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    // Metodo toString para una representación de texto del objeto
    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", notaMedia=" + notaMedia +
                '}';
    }
}
