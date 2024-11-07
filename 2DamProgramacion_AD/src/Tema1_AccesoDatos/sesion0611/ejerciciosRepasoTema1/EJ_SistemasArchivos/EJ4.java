package Tema1_AccesoDatos.sesion0611.ejerciciosRepasoTema1.EJ_SistemasArchivos;

import java.io.File;

public class EJ4 {
    public static void main(String[] args) {
        ComprobarArchivo(new File("C://Users//Iker//Desktop//Hola.txt"));
    }

    private static void ComprobarArchivo(File archivo) {
        if (archivo.exists()) {
            System.out.println("El archivo existe");
        } else {
            System.out.println("El archivo no existe");
        }
    }
}
