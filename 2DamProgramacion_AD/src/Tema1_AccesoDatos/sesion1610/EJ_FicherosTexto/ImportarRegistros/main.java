package Tema1_AccesoDatos.sesion1610.EJ_FicherosTexto.ImportarRegistros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    static public File ficheroAlumnos = new File("C://Users//Iker//Downloads//alumnos.csv");

    public static void main(String[] args) {
        ArrayList<Alumnos> listaAlumnos = leerFichero();
        ImprimirAlumnos(listaAlumnos);
    }
    private static ArrayList<Alumnos> leerFichero() {
        ArrayList<Alumnos> listaAlumnos = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(ficheroAlumnos));
            String line;
            while ((line = leer.readLine()) != null) {
                String[] datos = line.split(",");

                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String ciclo = datos[2];
                double notaMedia = Double.parseDouble(datos[3]);

                Alumnos alumno = new Alumnos(nombre, edad, ciclo, notaMedia);

                listaAlumnos.add(alumno);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }

    private static void ImprimirAlumnos(ArrayList<Alumnos> listaAlumnos) {
        for (Alumnos alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }

    private static void MayorNota(ArrayList<Alumnos> listaAlumnos) {
        for (Alumnos alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }


}
