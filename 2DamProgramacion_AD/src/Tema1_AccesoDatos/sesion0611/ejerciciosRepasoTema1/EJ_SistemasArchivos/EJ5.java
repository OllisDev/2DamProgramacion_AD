package Tema1_AccesoDatos.sesion0611.ejerciciosRepasoTema1.EJ_SistemasArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class EJ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una palabra que aparezca en el archivo: ");
        String palabra = sc.nextLine();


        palabraEspecifica(new File("C://Users//Iker//Desktop//prueba.txt"), palabra);
        System.out.println("Presiona Enter para salir...");
        sc.nextLine();
    }

    private static void palabraEspecifica(File archivo, String palabra) {
        if (archivo.exists() && archivo.isFile()) {
            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String line;
                int contadorPalabra = 0;
                while ((line = br.readLine()) != null) {

                    String lineLower = line.toLowerCase();
                    String palabraLower = palabra.toLowerCase();

                    String[] palabras = lineLower.split("\\s+");  // Divide por espacios en blanco
                    for (String p : palabras) {
                        p.trim();
                        if (p.equals(palabraLower)) {
                            contadorPalabra++;
                        }
                    }
                }
                System.out.println("La palabra \"" + palabra + "\" aparece " + contadorPalabra + " veces.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No existe el archivo");
        }
    }
}
