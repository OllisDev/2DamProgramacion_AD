package Tema1_AccesoDatos.sesion0911.FicherosTexto.Ejemplos;

import java.io.File;
import java.io.FileReader;


public class ejemploFicherosTexto_caracter {
    public static void main(String[] args) {
        // Crear un objeto File que representa el archivo "recuentoElementos.txt en la ruta especificada
        File f = new File("C://Users//Iker//Desktop//recuentoElementos.txt");
        try {
            // Crear un FileReader para leer el archivo de texto carácter por carácter
            FileReader fr = new FileReader(f);
            int c; // Variable para almacenar cada carácter leído en su forma de valor ASCII

            // Leer el archivo carácter por carácter
            while ((c = fr.read()) != -1) {
                // Convertir el código ASCII leído a su carácter correspondiente
                char letra = (char) c;

                // Imprimir el carácter en la consola
                System.out.println(letra);
            }

            // Cerrar el FileReader al finalizar la lectura
            fr.close();

        } catch (Exception e) {
            // Capturar y mostrar cualquier excepción que ocurra durante la lectura del archivo
            e.printStackTrace();
        }
    }
}

