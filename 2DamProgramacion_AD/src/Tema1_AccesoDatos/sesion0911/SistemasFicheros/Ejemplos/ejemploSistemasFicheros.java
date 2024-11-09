package Tema1_AccesoDatos.sesion0911.SistemasFicheros.Ejemplos;

import java.io.File;

public class ejemploSistemasFicheros {
    public static void main(String[] args) {  // Metodo principal, donde empieza la ejecución del programa

        String ruta = args[0];  // Se obtiene la ruta del fichero o directorio desde el primer argumento pasado por línea de comandos

        File f = new File(ruta);  // Creamos un objeto File con la ruta proporcionada

        if (f.exists()) {  // Comprobamos si el fichero o directorio existe

            if (f.isFile()) {  // Si la ruta corresponde a un fichero (no a un directorio)
                System.out.println("El tamaño es de: " + f.length());  // Imprimimos el tamaño del fichero
                System.out.println("Puede ejecutarse: " + f.canExecute());  // Imprimimos si se puede ejecutar el fichero
                System.out.println("Puede leerse: " + f.canRead());  // Imprimimos si se puede leer el fichero
                System.out.println("Puede escribirse: " + f.canWrite());  // Imprimimos si se puede escribir en el fichero

            } else {  // Si la ruta no es un fichero, asumimos que es un directorio
                String[] losArchivos = f.list();  // Obtenemos los archivos y directorios dentro de este directorio
                System.out.println("El directorio " + ruta + " contiene: ");  // Imprimimos el mensaje con el nombre del directorio
                for (String archivo : losArchivos) {  // Recorremos la lista de archivos dentro del directorio
                    System.out.println("\t" + archivo);  // Imprimimos el nombre de cada archivo o directorio dentro de él
                }
            }

        } else {  // Si el fichero o directorio no existe
            System.out.println("El fichero o ruta no existe");  // Imprimimos un mensaje indicando que la ruta no existe
        }
    }
}
