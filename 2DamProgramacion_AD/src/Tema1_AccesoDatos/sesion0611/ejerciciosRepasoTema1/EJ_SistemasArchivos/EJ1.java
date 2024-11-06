package Tema1_AccesoDatos.sesion0611.ejerciciosRepasoTema1.EJ_SistemasArchivos;

import java.io.File;

public class EJ1 {
    public static void main(String[] args) {
        File directorio = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0611"); // File: poner ruta de nuestro directorio
        // Verificar si la ruta es un directorio y si existe
        if(directorio.isDirectory() && directorio.exists()) {
            listarArchivos(directorio); // LLamada al metodo listarArchivos para poder listar cada uno de los archivos y subdirectorios que tenga el directorio principal
        } else {
            System.out.println("La ruta no existe.");
        }
    }

    public static void listarArchivos(File directorio) {
        File[] archivos = directorio.listFiles(); // listFiles(): listar todos los archivos de nuestro directorio mediante un array

        for(File archivo : archivos) { // Recorrer cada uno de los archivos y subdirectorios
            if (archivo.isDirectory()) { // Verificar si el elemento es un directorio
                System.out.println("Directorio: " + archivo.getAbsolutePath()); // si es un directorio, mostramos por pantalla la ruta absoluta del directorio (getAbsolutePath)
                listarArchivos(archivo); // Recursividad: llamar al metodo asi mismo para poder meterse al contenido de los subdirectorios del directorio
            } else {
                System.out.println("Archivo: " + archivo.getAbsolutePath()); // si es un archivo, mostramos por pantalla la ruta absoluta del archivo
            }
        }

    }
}
