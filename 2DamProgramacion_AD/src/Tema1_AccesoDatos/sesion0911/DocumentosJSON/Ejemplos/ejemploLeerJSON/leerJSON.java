package Tema1_AccesoDatos.sesion0911.DocumentosJSON.Ejemplos.ejemploLeerJSON;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class leerJSON {
    public static void main(String[] args) {
        try {
            // Ruta del archivo JSON
            String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//DocumentosJSON//Ejemplos//ejemploLeerJSON//Estudiante.json";

            // Leer el contenido del archivo JSON como texto
            String contenidoJSON = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            // Convertir el texto a un objeto JSON
            JSONObject jsonEstudiante = new JSONObject(contenidoJSON);

            // Obtener los valores del objeto JSON usando las claves
            String nombre = jsonEstudiante.getString("nombre"); // Obtiene el valor de "nombre"
            int edad = jsonEstudiante.getInt("edad");           // Obtiene el valor de "edad"
            String curso = jsonEstudiante.getString("curso");   // Obtiene el valor de "curso"

            // Imprimir los datos obtenidos del archivo JSON
            System.out.println("Datos del estudiante:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Curso: " + curso);

        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores en caso de que el archivo no exista o tenga formato incorrecto
        }
    }
}
