package Tema1_AccesoDatos.sesion0911.SistemasFicheros.Ejercicios;

import java.io.File;
import java.util.Scanner;

public class GestionDirectorios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del elemento:");
        String ruta = sc.next();

        listarContenido(new File(ruta)); // Llamada al metodo listarContenido para pasar por parametro la ruta del elemento que ha introducido el usuario
    }

    // Metodo listarContenido(): comprobar si el elemento existe y es un directorio o un fichero, dependiendo de lo que sea mostrara el tamaño en KB y si es un directorio mostrara que contenido tiene
    private static void listarContenido(File elemento) {
        if(elemento.exists() && elemento.isDirectory()) { // Verificar si el elemento existe y es un directorio
            System.out.println("El elemento es un directorio"); // Mostramos por pantalla que es un directorio
            System.out.println("Tamaño en KB: " + (elemento.length() / 1024) + " KB"); // Mostramos el tamaño en KB del directorio
            String[] archivos = elemento.list(); // Listamos el contenido del directorio
            System.out.println("El directorio " + elemento + " contiene: ");
            for (String archivo : archivos) { // Recorremos la lista de archivos del directorio
                System.out.println("\t" + archivo); // Mostramos por pantalla todos los archivos que contenga la lista
            }
        } else if (elemento.exists() && elemento.isFile()) { // Verificar si el elemento existe y es un fichero
            System.out.println("El elemento es un fichero."); // Mostramos por pantalla que es un directorio
            System.out.println("Tamaño en KB: " + (elemento.length() / 1024) + "KB"); // Mostramos por pantalla el tamaño en KB del fichero
        } else {
            System.out.println("El elemento no es un archivo ni un directorio ni existe");
        }
    }


}
