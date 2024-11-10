package Tema1_AccesoDatos.sesion0911.FicherosBinarios.Ejemplos.ejemploLecturaEscrituraArchivosBinarios_objetos;

import java.io.*;

public class ejemploLecturaEscrituraArchivosBinariosObjeto {
    public static void main(String[] args) {
        // Crear un objeto Alumno
        Alumno alumno1 = new Alumno("Juan Pérez", 22, 8.5);
        Alumno alumno2 = new Alumno("Ana García", 20, 9.1);

        // Archivo donde guardaremos los objetos binarios
        String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosBinarios//Ejemplos//ejemploLecturaEscrituraArchivosBinarios_objetos//alumnos.dat";

        // Guardamos los objetos en el archivo binario
        guardarAlumnoBinario(rutaArchivo, alumno1);
        guardarAlumnoBinario(rutaArchivo, alumno2);

        // Leemos los objetos del archivo binario
        leerAlumnosBinarios(rutaArchivo);
    }

    // Metodo para guardar un objeto Alumno en un archivo binario
    private static void guardarAlumnoBinario(String rutaArchivo, Alumno alumno) {
        // Usamos un FileOutputStream para abrir el archivo en modo binario
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo, false))) {
            // Escribimos el objeto en el archivo binario
            oos.writeObject(alumno);
            System.out.println("Alumno guardado: " + alumno);
        } catch (IOException e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }

    // Metodo para leer los objetos Alumno desde un archivo binario
    private static void leerAlumnosBinarios(String rutaArchivo) {
        // Usamos un FileInputStream para leer desde el archivo binario
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            // Leemos objetos hasta que el archivo no tenga más objetos
            while (true) {
                // Leemos el siguiente objeto (Alumno)
                Alumno alumno = (Alumno) ois.readObject();
                System.out.println("Alumno leído: " + alumno);
            }
        } catch (EOFException e) {
            // Esto indica que hemos llegado al final del archivo (fin de los objetos)
            System.out.println("Se han leído todos los objetos.");
        } catch (IOException | ClassNotFoundException e) {
            // Capturamos otros errores relacionados con la lectura de objetos
            System.out.println("Error al leer el objeto: " + e.getMessage());
        }
    }
}
