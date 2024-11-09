package Tema1_AccesoDatos.sesion0911.SistemasFicheros.Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class RecuentoElementos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo:");
        String ruta = sc.next();

        contarVocales(new File(ruta)); // Llamada metodo contarVocales() para pasarle por parametro la ruta introducida por el usuario
    }
    // Metodo contarVocales: comprobar si el fichero existe para posteriormente contar las vocales
    private static void contarVocales(File fichero) {
        if (fichero.exists()) { // Verificar si el fichero existe
            int contadorVocales = 0; // Guardamos en una variable un contador para poder saber cuantas vocales tiene nuestro fichero
            try {
                BufferedReader bf = new BufferedReader(new FileReader(fichero)); // Leemos el fichero linea por linea
                String line;
                while ((line = bf.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) { // Recorremos cada letra de la línea
                        char c = line.charAt(i);
                        // Verificamos si la letra corresponde a una vocal
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ) {
                            contadorVocales++; // Aumentamos el contador
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("No se pudo leer el archivo: " + e.getMessage());
            }
            System.out.println("Vocales del fichero: " + contadorVocales); // Mostramos por pantalla las vocales de nuestro fichero
        } else {
            System.out.println("El fichero no existe.");
        }
    }
}
