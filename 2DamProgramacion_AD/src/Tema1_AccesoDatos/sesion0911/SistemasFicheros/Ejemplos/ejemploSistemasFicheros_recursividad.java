package Tema1_AccesoDatos.sesion0911.SistemasFicheros.Ejemplos;

import java.io.File;

public class ejemploSistemasFicheros_recursividad {
    public static void main(String[] args) {
        String ruta = args[0];  // Tomamos la ruta del directorio a procesar desde los argumentos de la línea de comandos
        File directorio = new File(ruta);  // Creamos un objeto File con la ruta proporcionada

        // Comprobamos si el directorio existe y es un directorio
        if (directorio.exists() && directorio.isDirectory()) {
            System.out.println("Contenido del directorio: " + ruta);
            recorrerDirectorio(directorio);  // Llamamos a la función recursiva para recorrer el directorio
        } else {
            System.out.println("La ruta no es un directorio válido o no existe.");
        }
    }

    // Metodo recursivo para recorrer un directorio
    public static void recorrerDirectorio(File directorio) {
        // Obtenemos la lista de archivos y subdirectorios en el directorio actual
        File[] archivos = directorio.listFiles();

        if (archivos != null) {  // Verificamos si la lista de archivos no está vacía
            for (File archivo : archivos) {
                // Si es un directorio, imprimimos el nombre y llamamos recursivamente a la función para recorrerlo
                if (archivo.isDirectory()) {
                    System.out.println("Directorio: " + archivo.getAbsolutePath());
                    recorrerDirectorio(archivo);  // Llamada recursiva para el subdirectorio
                } else {
                    // Si es un archivo, simplemente imprimimos su nombre
                    System.out.println("Archivo: " + archivo.getAbsolutePath());
                }
            }
        }
    }
}
