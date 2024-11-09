package Tema1_AccesoDatos.SistemasFicheros;

import java.io.File;
import java.util.Scanner;

public class GestionFIcheros2 {
    public class GestionFicheros2 {
        // Contadores para archivos y directorios encontrados
        private static int contadorFicheros = 0;
        private static int contadorDirectorios = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            boolean esRecursivo = false;

            // Verifica si hay un argumento "-r" para listar de forma recursiva
            if (args.length == 1) {
                esRecursivo = args[0].equals("-r");
            }

            // Solicita al usuario la ruta del directorio
            System.out.println("Introduce la ruta del fichero: ");
            String rutaFichero = sc.next();

            // Crea un objeto File a partir de la ruta
            File f = new File(rutaFichero);

            // Verifica si la ruta existe y es un directorio
            if(f.exists() && f.isDirectory()) {
                System.out.println("El directorio " + rutaFichero + " contiene:");
                listarContenido(f, esRecursivo, 0); // Llama al método para listar contenido
            } else {
                System.out.println("El archivo o ruta no existe o no es un directorio");
            }
        }

        // Método para listar el contenido del directorio
        public static void listarContenido(File dir, boolean esRecursivo, int nivel) {
            // Obtiene una lista de archivos y directorios dentro del directorio actual
            File[] archivosList = dir.listFiles();

            // Si la lista no está vacía, recorre cada archivo o directorio
            if (archivosList != null) {
                for (File archivo : archivosList) {
                    // Indentación para mostrar la jerarquía de carpetas
                    String indentacion = "\t".repeat(nivel);

                    // Si es un archivo, muestra el nombre y el tamaño en KB, y aumenta el contador
                    if (archivo.isFile()) {
                        System.out.println(
                                indentacion + "fichero: " + archivo.getName() + " " + (archivo.length() / 1024) + " KB");
                        contadorFicheros++;

                        // Si es un directorio, muestra el nombre y el tamaño en KB, y aumenta el contador de directorios
                    } else if (archivo.isDirectory()) {
                        System.out.println(indentacion + "directorio: " + archivo.getName() + " " + (archivo.length() / 1024.0) + " KB");
                        contadorDirectorios++;

                        // Si es recursivo, llama de nuevo al método para listar el contenido de este directorio
                        if (esRecursivo) {
                            listarContenido(archivo, true, nivel + 1);
                        }
                    }
                }
            }
        }
    }
}