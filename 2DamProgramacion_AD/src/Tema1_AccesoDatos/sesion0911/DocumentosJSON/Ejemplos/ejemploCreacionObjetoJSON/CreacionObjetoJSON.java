package Tema1_AccesoDatos.sesion0911.DocumentosJSON.Ejemplos.ejemploCreacionObjetoJSON;

import org.json.JSONObject;

public class CreacionObjetoJSON {
    public static void main(String[] args) {
        // Crear un objeto Estudiante con datos de ejemplo
        Estudiante estudiante = new Estudiante("Juan", 22, "Programación");

        // Crear un JSONObject y agregar los datos del objeto Estudiante
        JSONObject jsonEstudiante = new JSONObject();

        // Usar los métodos put para agregar los atributos del objeto Java al JSONObject
        jsonEstudiante.put("nombre", estudiante.getNombre());
        jsonEstudiante.put("edad", estudiante.getEdad());
        jsonEstudiante.put("curso", estudiante.getCurso());

        // Imprimir el objeto JSON en formato de cadena
        System.out.println("Objeto JSON generado:");
        System.out.println(jsonEstudiante.toString(4)); // El argumento 4 indica indentación para legibilidad
    }
}

