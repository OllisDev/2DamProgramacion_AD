package Tema1_AccesoDatos.sesion0911.DocumentosJSON.Ejemplos.ejemploLeerJSON;

public class Estudiante {
    private String nombre;
    private int edad;
    private String curso;

    // Constructor
    public Estudiante(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Métodos getter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }
}
