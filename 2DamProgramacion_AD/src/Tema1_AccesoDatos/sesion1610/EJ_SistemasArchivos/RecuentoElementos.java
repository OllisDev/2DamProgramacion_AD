package Tema1_AccesoDatos.sesion1610.EJ_SistemasArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecuentoElementos {
    private static File archivo = new File("C://Users//Iker//Downloads//Hola.txt");
    private static char[] vocales = {'a','e','i','o','u','A','E','I','O','U'};

    public static void main(String[] args) throws IOException {
        verificacionFichero();
        contarVocales();
    }

    private static void verificacionFichero() throws IOException {
        if (!archivo.exists()) {
            System.out.println("El fichero no existe");
            System.out.println("Creando fichero automaticamente...");
            archivo.createNewFile();
            System.out.println("El fichero ha sido creado correctamente en: " + archivo.getAbsolutePath());
        } else {
            System.out.println("El fichero existe en: " + archivo.getAbsolutePath());
        }
    }

    private static void contarVocales() {
        try {
            FileReader leer = new FileReader(archivo);
            BufferedReader leerArchivo = new BufferedReader(leer);

            int caracter;
            int contadorVocales = 0;

            while ((caracter = leer.read()) != -1) {
                char letra = (char) caracter;
                System.out.println(letra + " ");
                for(int i = 0; i < vocales.length; i++) {
                    if (caracter == vocales[i]) {
                        contadorVocales++;
                    }
                }
            }
            System.out.println("Contador de vocales: " + contadorVocales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
