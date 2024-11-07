package Tema1_AccesoDatos.sesion0611.ejerciciosRepasoTema1.EJ_SistemasArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EJ3 {
    public static void main(String[] args) {
        leerArchivo(new File("C:/Users//Iker//Desktop//Hola.txt"));
    }

    private static void leerArchivo(File archivo) {
        if (archivo.exists() && archivo.isFile()) {
            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("El archivo no existe");
        }
    }
}
