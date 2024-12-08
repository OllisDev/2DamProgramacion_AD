package Tema1_AccesoDatos.sesion0512;

import java.io.*;
import java.util.Scanner;

public class CifradoArchivos {

	public static void main(String[] args) {
		// TODO: Crea el objeto Scanner
        Scanner sc = new Scanner(System.in);

        // TODO: Solicitar la ruta del archivo al usuario y guardala en la variable rutaArchivo
        System.out.println("Introduce la ruta del archivo: ");
        String path = sc.next();

		// TODO: Solicitar la clave numérica para cifrado o descifrado y guardala en la variable clave
        System.out.println("Introduce la clave numérica: ");
        int clave = sc.nextInt();

		// TODO: Solicitar al usuario que elija entre cifrar o descifrar y guardala en la variable opcion 
        System.out.println("Eliga una opción: cifrar o descifrar");
        String opcion = sc.next();
		
        // TODO: Crear un objeto File para representar el archivo llamado archivo
        File file = new File(path);
		
        // TODO: Verificar si el archivo existe y es un archivo válido, si no lo es lanza un mensaje de error y termina el programa
        if (file.exists() && file.isFile()) {
            System.out.println("El archivo es válido");
        } else {
            System.out.println("El archivo no es váido.");
            System.exit(0);
        }
		

        // TODO: Determinar el sufijo del fichero resultante de nuestra operación 
        // basado en la opción seleccionada (cifrar o descifrar)
        // Recupera el valor de la opción en una variable llamada sufijo
        // Utiliza el if de profesionales ()?:
        String sufijo = (file.isFile())?"cifrar":"descifrar";


        // TODO: Crear un objeto File para representar el archivo llamado archivoSalida a partir del archivo padre 
        // nombre.getName().replaceFirst("\\.[^.]+$", sufijo + "$0")

        File archivoSalida = new File(path);

		

        // TODO: dentro de un try(Abrir el archivo original para lectura y preparar un nuevo archivo para escritura)
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));
			// TODO: Declara un int caracter
            String caracter;

            // TODO: Leer el archivo carácter por carácter
            while ((caracter = bf.readLine()) != null) {
                // TODO: Realizar la operación de cifrado o descifrado según la opción

            }

                
            

            // TODO: Confirmar que la operación se ha completado y mostrar la ruta del archivo generado
           

            // TODO: Manejar errores de lectura/escritura e informar al usuario
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

