package Tema1_AccesoDatos.sesion0911.FicherosBinarios.Ejemplos;

import java.io.*;

public class ejemploLecturaEscrituraArchivosBinariosDatos {
    public static void main(String[] args) {
        // Ruta del archivo binario
        String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosBinarios//Ejemplos//alumnos.dat";

        // Guardamos los datos binarios
        guardarDatosBinarios(rutaArchivo);

        // Leemos los datos binarios
        leerDatosBinarios(rutaArchivo);
    }

    // Metodo para guardar datos binarios
    public static void guardarDatosBinarios(String rutaArchivo) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo))) {
            // Escribimos varios tipos de datos en el archivo
            dos.writeUTF("Juan Pérez");  // Escribe una cadena de texto
            dos.writeInt(22);            // Escribe un entero
            dos.writeDouble(8.5);        // Escribe un número decimal

            dos.writeUTF("Ana García");
            dos.writeInt(20);
            dos.writeDouble(9.1);

            System.out.println("Datos binarios guardados con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos binarios: " + e.getMessage());
        }
    }

    // Metodo para leer datos binarios
    public static void leerDatosBinarios(String rutaArchivo) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(rutaArchivo))) {
            // Leemos los datos del archivo en el mismo orden en que se escribieron
            String nombre1 = dis.readUTF();
            int edad1 = dis.readInt();
            double notaMedia1 = dis.readDouble();

            String nombre2 = dis.readUTF();
            int edad2 = dis.readInt();
            double notaMedia2 = dis.readDouble();

            // Mostramos los datos leídos en consola
            System.out.println("Alumno 1: " + nombre1 + ", Edad: " + edad1 + ", Nota Media: " + notaMedia1);
            System.out.println("Alumno 2: " + nombre2 + ", Edad: " + edad2 + ", Nota Media: " + notaMedia2);
        } catch (IOException e) {
            System.out.println("Error al leer los datos binarios: " + e.getMessage());
        }
    }
}
