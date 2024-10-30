package Tema1_AccesoDatos.sesion1610.EJ_FicherosTexto.ImportarRegistros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class main {
    static public File ficheroAlumnos = new File("C://Users//Iker//Downloads//alumnos.csv");

    public static void main(String[] args) {
        ArrayList<Alumnos> listaAlumnos = leerFichero();
        ImprimirAlumnos(listaAlumnos);

        MostrarAlumnoMayorNota(listaAlumnos);
    }
    private static ArrayList<Alumnos> leerFichero() {
        ArrayList<Alumnos> lista = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader(ficheroAlumnos));
            String line;
            String[] linea;
            while ((line = leer.readLine()) != null) {
                System.out.println(line);
                linea = line.split(";");
                String nombre = linea[0];
                int edad = Integer.parseInt(linea[1]);
                String ciclo = linea[2];
                double notaMedia = Double.parseDouble(linea[3]);
                Alumnos alumno = new Alumnos(nombre, edad, ciclo, notaMedia);
                lista.add(alumno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private static void ImprimirAlumnos(ArrayList<Alumnos> listaAlumnos){
        for (Alumnos alumno : listaAlumnos) {
            System.out.println(alumno);
        }
    }

    private static void MostrarAlumnoMayorNota(ArrayList<Alumnos> listaAlumnos) {
        Alumnos alumnoMayorNota = null;
        double notaMaxima = -1;

        for (Alumnos alumno : listaAlumnos) {
            if(alumno.getNotaMedia() > notaMaxima) {
                notaMaxima = alumno.getNotaMedia();
                alumnoMayorNota = alumno;
            }
       }
        System.out.println("El alumno con mayor nota es: " + alumnoMayorNota.getNombre());
    }

    private static void DevolverRepresentacionAlumno() {

    }


}

