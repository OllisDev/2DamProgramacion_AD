package Tema1_AccesoDatos.sesion1610.EJ_SistemasArchivos;

import java.io.File;

public class GestionDirectorio {
    public static void main(String[] args) {
        ComprobacionRuta();
    }

    private static void ComprobacionRuta() {
        File rutaDirectorio = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion1610//EJ_SistemasArchivos");
        if (rutaDirectorio.exists() && rutaDirectorio.isDirectory()) {
            File[] listar = rutaDirectorio.listFiles();

            if (listar != null) {
                for (File file : listar) {
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
