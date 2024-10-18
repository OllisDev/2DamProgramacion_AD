package Tema1_AccesoDatos.sesion1610.EJ_SistemasArchivos;

import java.io.File;

public class GestionDirectorio {
    public static void main(String[] args) {
        ComprobacionRuta();
    }

    private static void ComprobacionRuta() {
        File rutaDirectorio = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion1610//EJ_SistemasArchivos"); // Ruta del directorio
        if (rutaDirectorio.exists() && rutaDirectorio.isDirectory()) { // Verificacion de si el archivo existe y si es un directorio para poder listar todos los archivos del directorio
            File[] listar = rutaDirectorio.listFiles();

            if (listar != null) { // Verificacion de si listamos un fichero o no listamos nada
                for (File file : listar) { // for-each: recorrer el directorio mediante los distintos ficheros para poder comprobar que cada uno de ellos sea un fichero o un directorio
                    if (file.isFile()) {
                        System.out.println(file.getName() + " es un fichero");
                        System.out.println("Tamaño del fichero: " + (file.length() / 1024) + " Kb");
                    } else if (file.isDirectory()){
                        System.out.println(file.getName() + " es un directorio");
                        System.out.println("Tamaño del directorio: " + (TamañoDirectorio(file) / 1024) + " Kb");
                    }
                }
            }
         } else {
            System.out.println("ERROR - No existe el directorio");
        }


    }

    // Función TamañoDirectorio(): funcion que nos sirve para poder mostrar e indicar todos aquellos directorios que se encuentren en nuestra gestion de directorios
    private static long TamañoDirectorio(File directorio) {
        long tamaño = 0;
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    tamaño += archivo.length();
                } else if (archivo.isDirectory()){
                    tamaño += TamañoDirectorio(archivo);
                }
            }
        }
        return tamaño;
    }
}
