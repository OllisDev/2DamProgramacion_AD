package Tema1_AccesoDatos.sesion0911.FicherosTexto.Ejercicios.ImportarRegistros;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase principal que contiene el método main, donde se ejecuta el programa
public class main {

    // Metodo main donde se ejecuta el programa
    public static void main(String[] args) {

        // Se crea un objeto File que representa el archivo CSV de los alumnos
        File f = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosTexto//Ejercicios//ImportarRegistros//alumnos.csv");

        // Se llama al metodo importarAlumnos para leer los datos del archivo y almacenarlos en una lista de alumnos
        ArrayList<Alumnos> alumnosList = importarAlumnos(f);

        // Se llama al metodo imprimirAlumnos para imprimir todos los alumnos en la lista
        imprimirAlumnos(alumnosList);

        // Se llama al metodo alumnoMayorNota para encontrar al alumno con la mayor nota media
        alumnoMayorNota(alumnosList);

        // Se crea un objeto File que representa el archivo CSV donde se guardarán los alumnos aprobados
        File alumnosAprobados = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosTexto//Ejercicios//ImportarRegistros//alumnosAprobados.csv");

        // Se llama al metodo generarAlumnosAprobados para generar un archivo con los alumnos que tienen una nota media >= 5
        generarAlumnosAprobados(alumnosAprobados, alumnosList);

        // Se crea un objeto File que representa el archivo CSV donde se guardarán los alumnos con su representación
        File representacionAlumno = new File("C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosTexto//Ejercicios//ImportarRegistros//representacionAlumno.csv");

        // Se llama al metodo devolverRepresentacionAlumno para generar un archivo con los datos de todos los alumnos
        devolverRepresentacionAlumno(representacionAlumno, alumnosList);
    }

    // Metodo para importar alumnos desde un archivo CSV
    private static ArrayList<Alumnos> importarAlumnos(File fichero) {
        // Lista que almacenará los alumnos importados
        ArrayList<Alumnos> lista = new ArrayList<>();

        // Se intenta leer el archivo CSV
        try {
            // Se crea un objeto FileReader para leer el archivo y un BufferedReader para leer las líneas
            FileReader fr = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            String[] linea;

            // Se lee cada línea del archivo
            while ((line = bf.readLine()) != null) {
                // Imprime cada línea leída en consola
                System.out.println(line);

                // Se separa la línea por el delimitador ";"
                linea = line.split(";");

                // Se obtienen los datos del alumno a partir de los elementos separados
                String nombre = linea[0];
                int edad = Integer.parseInt(linea[1]);
                String ciclo = linea[2];
                double notaMedia = Double.parseDouble(linea[3]);

                // Se crea un nuevo objeto Alumno con los datos obtenidos
                Alumnos alumno = new Alumnos(nombre, edad, ciclo, notaMedia);

                // Se añade el alumno a la lista de alumnos
                lista.add(alumno);
            }
        } catch (Exception e) {
            // Si hay un error, se imprime el mensaje de error
            System.out.println("Error: " + e.getMessage());
        }

        // Se retorna la lista de alumnos
        return lista;
    }

    // Metodo para imprimir la información de todos los alumnos en la lista
    private static void imprimirAlumnos(ArrayList<Alumnos> listaAlumnos) {
        // Se recorre la lista de alumnos e imprime cada uno
        for (Alumnos alumnos : listaAlumnos) {
            System.out.println(alumnos);
        }
    }

    // Metodo para encontrar al alumno con la mayor nota media
    private static void alumnoMayorNota(ArrayList<Alumnos> listaAlumnos) {
        // Variables para almacenar el alumno con mayor nota y la nota máxima
        Alumnos alumnoMayorNota = null;
        double notaMaxima = -1;

        // Se recorre la lista de alumnos
        for (Alumnos alumno : listaAlumnos) {
            // Si el alumno tiene una nota media mayor que la máxima, se actualiza
            if (alumno.getNotaMedia() > notaMaxima) {
                notaMaxima = alumno.getNotaMedia();
                alumnoMayorNota = alumno;
            }
        }

        // Se imprime el nombre del alumno con mayor nota media
        System.out.println("El alumno con mayor nota media es: " + alumnoMayorNota.getNombre());
    }

    // Metodo para generar un archivo CSV con la representación de todos los alumnos
    private static void devolverRepresentacionAlumno(File ficheroCSV, ArrayList<Alumnos> alumno) {
        // Si el archivo no existe, se procede a crearlo
        if (!ficheroCSV.exists()) {
            try {
                // Se crea un objeto FileWriter y BufferedWriter para escribir el archivo CSV
                FileWriter fw = new FileWriter(ficheroCSV);
                BufferedWriter bw = new BufferedWriter(fw);

                // Se escribe la cabecera del archivo CSV
                bw.write("Nombre, Edad, Ciclo, NotaMedia");
                bw.newLine();

                // Se recorre la lista de alumnos y se escribe la información de cada uno en el archivo
                for (Alumnos alumnos : alumno) {
                    String linea = alumnos.getNombre() + ", " + alumnos.getEdad() + ", " + alumnos.getCiclo() + ", " + alumnos.getNotaMedia();
                    bw.write(linea);
                    bw.newLine();
                }

                // Se cierra el BufferedWriter
                bw.close();
                // Se imprime un mensaje de éxito
                System.out.println("Archivo de representación de alumnos generado con éxito.");
            } catch (IOException e) {
                // Si hay un error, se imprime el mensaje de error
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            // Si el archivo ya existe, se imprime un mensaje indicando que no se creará
            System.out.println("El fichero ya existe");
        }
    }

    // Metodo para generar un archivo CSV con los alumnos aprobados (nota media >= 5)
    private static void generarAlumnosAprobados(File ficheroCSV, ArrayList<Alumnos> listaAlumnosAprobados) {
        try {
            // Se crea un objeto FileWriter y BufferedWriter para escribir el archivo CSV
            FileWriter fw = new FileWriter(ficheroCSV);
            BufferedWriter bw = new BufferedWriter(fw);

            // Se escribe la cabecera del archivo CSV
            bw.write("Nombre, Edad, Ciclo, NotaMedia");
            bw.newLine();

            // Se recorre la lista de alumnos y se escribe la información de los alumnos aprobados
            for (Alumnos alumno : listaAlumnosAprobados) {
                if (alumno.getNotaMedia() >= 5.0) {
                    String linea = alumno.getNombre() + ", " + alumno.getEdad() + ", " + alumno.getCiclo() + ", " + alumno.getNotaMedia();
                    bw.write(linea);
                    bw.newLine();
                }
            }

            // Se cierra el BufferedWriter
            bw.close();

            // Se imprime un mensaje de éxito
            System.out.println("Archivo de alumnos aprobados generado con éxito.");
        } catch (Exception e) {
            // Si hay un error, se imprime el mensaje de error
            System.out.println("Error: " + e.getMessage());
        }
    }
}

