package Tema1_AccesoDatos.sesion0911.FicherosTexto.Ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ejemploFicherosTexto_linea {
    public static void main(String[] args) {
        // Ruta del archivo que queremos leer
        File archivo = new File("C://Users//Iker//Desktop//recuentoElementos.txt");

        // Intentamos abrir y leer el archivo, capturando posibles excepciones
        try {
            // Creamos un FileReader para leer el archivo
            FileReader fr = new FileReader(archivo);

            // Envolvemos el FileReader en un BufferedReader para leer líneas completas
            BufferedReader br = new BufferedReader(fr);

            // Variable para almacenar cada línea leída
            String linea;

            // Bucle que lee cada línea del archivo hasta que no haya más (devuelve null)
            while ((linea = br.readLine()) != null) {
                // Imprimimos la línea en la consola
                System.out.println(linea);
            }

            // Cerramos el BufferedReader al finalizar la lectura
            br.close();

        } catch (IOException e) {
            // Si ocurre un error de entrada/salida (por ejemplo, archivo no encontrado), se imprime el stack trace de la excepción para depuración
            e.printStackTrace();
        }
    }
}
