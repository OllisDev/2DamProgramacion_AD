package Tema1_AccesoDatos.sesion0411.ficherosBinariosEntero;

import java.io.*;

public class main {
    public static void guardarAlumno(Alumno alumno) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Alumno.dat"))) {
            oos.writeObject(alumno);
            System.out.println("Datos guardados correctamente en Alumno.dat");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static void leerAlumno() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Alumno.dat"))) {
            Alumno alumno = (Alumno) ois.readObject();
            System.out.println("Datos leídos desde Alumno.dat:");
            System.out.println(alumno);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }
}
