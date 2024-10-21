package Tema1_AccesoDatos.sesion1610.EJ_FicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CaracteristicasFichero {
    static File elemento = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion1610//EJ_SistemasArchivos//RecuentoElementos.java"); // elemento para saber sus propiedades
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) { // Menu: bucle para poder realizar mas funciones hasta que queramos salir del programa
            System.out.println("¡Bienvenido!");
            System.out.println("Elige una opción:");
            System.out.println("1. Mostrar nombre del elemento");
            System.out.println("2. Mostrar ruta completa del elemento");
            System.out.println("3. Mostrar tamaño del elemento");
            System.out.println("4. Mostrar la ultima modificación del elemento");
            System.out.println("5. Mostrar si es un directorio o un fichero el elemento");
            System.out.println("6. Salir del programa");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            System.out.println("Opción: " + opcion);

            switch (opcion) {
                case 1: {
                    PropiedadNombre();
                    break;
                }
                case 2: {
                    PropiedadRuta();
                    break;
                }
                case 3: {
                    PropiedadTamaño();
                    break;
                }
                case 4: {
                    PropiedadUltimaModificacion();
                    break;
                }
                case 5: {
                    PropiedadDirectorioFichero();
                    break;
                }
                case 6: {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                }
                default: {
                    System.out.println("ERROR - Seleccione una opción válida");
                }
            }

        }
    }

    // Metodo PropiedadDirectorioFichero(): comprobacion mediante if de si el elemento es un directorio o un fichero
    private static void PropiedadDirectorioFichero() {
        if (elemento.isDirectory()) {
            System.out.println(elemento.getAbsolutePath() + " es un directorio");
        } else {
            System.out.println(elemento.getAbsolutePath() + " es un fichero");
        }
    }

    // Metodo PropiedadTamaño(): comprobacion mediante if de si el elemento es un directorio y saber su tamaño en Kb (utilizamos una funcion llamada TamañoDirectorio para poder saber exactamente el tamaño del directorio) o es un fichero y saber su tamaño en Kb mendiante la funcion length() y dividirlo entre 1024 bytes
    private static void PropiedadTamaño() {
        if (elemento.isDirectory()) {
            System.out.println("Tamaño del elemento: " + (TamañoDirectorio(elemento) / 1024) + " kb");
        } else {
            System.out.println("Tamaño del elemento: " + (elemento.length() / 1024) + " Kb");
        }
    }

    // Metodo PropiedadUltimaModificacion(): utilizamos la función lastModified() para saber la fecha de la última modificacion del elemento, pero necesitamos utilizar la clase Date para poder ponerlo en formato de fecha, ya que la funcion por defecto te lo muestra en milisengundos
    private static void PropiedadUltimaModificacion() {
        long ultimaModificacionMilisegundos = elemento.lastModified();
        Date ultimaModificacionFecha = new Date(ultimaModificacionMilisegundos);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Última modificación: " + formatoFecha.format((ultimaModificacionFecha)));
    }

    // Metodo PropiedadNombre(): utilizamos la funcion getName() para obtener el nombre del elemento
    private static void PropiedadNombre() {
        System.out.println("Nombre del elemento: " + elemento.getName());
    }

    // MetodoPropiedadRuta(): utilizamos la función getAbsolutePath() para obtener la ruta absoluta del elemento
    private static void PropiedadRuta() {
        System.out.println("Ruta del elemento: " + elemento.getAbsolutePath());
    }

    private static long TamañoDirectorio(File directorio) {
        long tamaño = 0;
        File[] archivos = directorio.listFiles();

        if(archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    tamaño += archivo.length();
                } else if (archivo.isDirectory()){
                    tamaño += TamañoDirectorio(archivo);
                }
            }
        }
        return tamaño;
    }
}


