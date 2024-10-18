package Tema1_AccesoDatos.sesion1610.EJ_SistemasArchivos;

import java.io.*;

public class RecuentoElementos {
    private static File archivo = new File("C://Users//Iker//Downloads//Hola.txt"); // Ruta del archivo
    private static char[] vocales = {'a','e','i','o','u','A','E','I','O','U'}; // Lista de las vocales guardadas en un Array

    public static void main(String[] args) throws IOException {
        verificacionFichero(); // LLamada al metodo verificaciónFichero()
        contarVocales(); // LLamada al metodo contarVocales()
    }

    // Metodo verificacionFichero()
    private static void verificacionFichero() throws IOException {
        if (!archivo.exists()) { // Verificación de si el archivo existe o no. Si existe imprimirá un mensaje donde indique la ruta donde se ubique, si no existe, creará automaticamente el archivo
            System.out.println("El fichero no existe");
            System.out.println("Creando fichero automaticamente...");
            archivo.createNewFile();
            System.out.println("El fichero ha sido creado correctamente en: " + archivo.getAbsolutePath());
        } else {
            System.out.println("El fichero existe en: " + archivo.getAbsolutePath());
        }

    }


    // Metodo contarVocales()
    private static void contarVocales() {

        try (FileReader leer = new FileReader(archivo); // Leer archivo
             BufferedReader leerArchivo = new BufferedReader(leer);) {

            int caracter;
            int contadorVocales = 0;


            while ((caracter = leerArchivo.read()) != -1) { // Lee el archivo mediante caracter a caracter del archivo
                char letra = (char) caracter;
                for(int i = 0; i < vocales.length; i++) { // Recorrer cada caracter que sea una vocal y sumarla al contador de vocales
                    if (letra == vocales[i]) {
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
