package Tema1_AccesoDatos.sesion0911.FicherosTexto.Ejercicios;

import java.io.File;
import java.util.Scanner;

public class CaracteristicasFichero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del elemento:");
        String ruta = sc.next();

        propiedadesElemento(new File(ruta)); // Llamada del metodo propiedadesElemento como parametro la ruta establecida por el usuarip
    }

    // Metodo propiedadesElemento(): mostrar todas las propiedades del elemento ya sea un directorio como un fichero
    private static void propiedadesElemento(File elemento) {
        // Verificar si es un fichero y si existe
        if (elemento.isFile() && elemento.exists()) {
            System.out.println("Tamaño del fichero: " + (elemento.length() / 1024) + " KB"); // length(): mostrar tamaño del fichero
            if (elemento.canRead()) { // Verificar si el usuario tiene permisos de lectura o no
                System.out.println("Tienes permiso de lectura del fichero " + elemento);
            } else {
                System.out.println("No tienes permiso de lectura del fichero " + elemento);
            }
            if (elemento.canWrite()) { // Verificar si el usuario tiene permisos de escritura o no
                System.out.println("Tienes permiso de escritura del fichero " + elemento);
            } else {
                System.out.println("No tienes permiso de escritura del fichero " + elemento);
            }
            if (elemento.canExecute()) { // Verificar si el usuario tiene permisos de ejecución o no
                System.out.println("Tienes permiso de ejecución del fichero " + elemento);
            } else {
                System.out.println("No tienes permiso de ejecución del fichero " + elemento);
            }
        } else if (elemento.isDirectory() && elemento.exists()) { // Verificar si es un directorio y si existe
            String[] directorioList = elemento.list(); // Listamos todos los archivos que contenga el directorio
            System.out.println("Tamaño del directorio: " + (elemento.length() / 1024) + "KB"); // Mostramos el tamaño del directorio
            System.out.println("El directorio " + elemento + " contiene:");
            for (String archivo : directorioList) { // Recorremos todos los archivos del directorio y lo mostramos de manera tabulada
                System.out.println("\t" + archivo);
            }
        } else {
            System.out.println("La ruta del elemento no existe");
        }
    }
}
