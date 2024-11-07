package Tema1_AccesoDatos.sesion0611.ejerciciosRepasoTema1.EJ_SistemasArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EJ2 {
    public static void main(String[] args) {
        contarPalabras(new File("C://Users//Iker//Desktop//Hola.txt")); // LLamada al metodo contarPalabras para pasar como parametro la ruta del archivo
    }
    // Metodo para poder contar palabras de nuestro archivo
    private static void contarPalabras(File archivo) {
        if(archivo.exists() && archivo.isFile()) { // Verificar si el archivo existe y si es un archivo
            try {
                FileReader fr = new FileReader(archivo); // FileReader: clase que nos permite leer un archvo
                BufferedReader bf = new BufferedReader(fr); //BufferedReader: clase que nos permite leer un archivo linea a linea
                String line = ""; // Guardamos en una variable inicializada la linea

                int contadorPalabras = 0;

                while((line = bf.readLine()) != null) { // este bucle while hace leer nuestro archivo linea a linea, pero si no hay nada en el archivo lo detectará como null
                    String[] palabras = line.split("\\s+"); // separamos las palabras en uno o más espacios mediante la función split(

                    // Guardamos en una variable el contador de palabras para poder contar el numero de palabras que hay en esa línea
                    contadorPalabras = contadorPalabras + palabras.length;
                    System.out.println("Palabras: " + contadorPalabras); // Mostramos por pantalla el total de palabras de nuestro archivo
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("El archivo no existe");
        }
    }
}
