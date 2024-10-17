package Tema1_AccesoDatos.sesion1610.EJ_SistemasArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestionDirectorio {
    public static void main(String[] args) {
        ComprobacionRuta();
    }

    private static void ComprobacionRuta() {
        File rutaDirectorio = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion1610//EJ_SistemasArchivos");
        if (rutaDirectorio.exists()) {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("cmd.exe", "/c", "dir");

            try {
                Process p = pb.start();
                BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;

                while ((line = leer.readLine()) != null) {
                    System.out.println(line);
                }

                int ExitCode = p.waitFor();
                System.out.println("Código de salida: " + ExitCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
         } else {
            System.out.println("ERROR - No existe el directorio");
        }
    }
}
