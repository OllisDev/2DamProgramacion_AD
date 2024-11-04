package Tema1_AccesoDatos.SistemasFicheros;

import java.io.File;
import java.util.Scanner;

public class GestionFIcheros2 {
    private static int contadorFicheros = 0;
    private static int contadorDirectorios = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esRecursivo = false;


        if (args.length == 1) {
            esRecursivo = args[0].equals("-r");
        }

        System.out.println("Introduce la ruta del fichero: ");
        String rutaFichero = sc.next();

        File f = new File(rutaFichero);

        if(f.exists() && f.isDirectory()) {
            System.out.println("El directorio " + rutaFichero + " contiene:");
            listarContenido(f, esRecursivo, 0);
        } else {
            System.out.println("El archivo o ruta no existe o no es un directorio");
        }
    }

    public static void listarContenido(File dir, boolean esRecursivo, int nivel) {
        File[] archivosList = dir.listFiles();
        if (archivosList != null) {
            for (File archivo : archivosList) {
                String indentacion = "\t".repeat(nivel);

                if (archivo.isFile()) {
                    System.out.println(
                            indentacion + "fichero: " + archivo.getName() + " " + (archivo.length() / 1024) + " KB");
                    contadorFicheros++;
                } else if (archivo.isDirectory()) {
                    System.out.println(indentacion + "directorio: " + archivo.getName() + " " + (archivo.length() / 1024.0) + " KB");
                    contadorDirectorios++;
                    if (esRecursivo) {
                        listarContenido(archivo, true, nivel + 1);
                    }
                }
            }
        }
    }
}
