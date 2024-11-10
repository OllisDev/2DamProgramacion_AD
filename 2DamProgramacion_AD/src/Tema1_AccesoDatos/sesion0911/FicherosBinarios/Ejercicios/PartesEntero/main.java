package Tema1_AccesoDatos.sesion0911.FicherosBinarios.Ejercicios.PartesEntero;


import java.io.*;


public class main {
    public static void main(String[] args) {
        String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosBinarios//Ejercicios//PartesEntero//Alumno.dat";
        Alumno alumno1 = new Alumno("Iker", 19, "DAM");
        Alumno alumno2 = new Alumno("Aitor", 16, "3ºESO");

        // Guardamos los alumnos
        guardarAlumno(rutaArchivo, alumno1);
        guardarAlumno(rutaArchivo, alumno2);

        // Leemos los alumnos
        leerAlumno(rutaArchivo);
    }

    private static void guardarAlumno(String rutaArchivo, Alumno alumno) {
        try {
            // Verificamos si el archivo ya existe
            File archivo = new File(rutaArchivo);
            boolean appendMode = archivo.exists();

            // Abrimos el archivo en modo append o en modo normal
            ObjectOutputStream oos = appendMode
                    ? new ObjectOutputStream(new FileOutputStream(rutaArchivo, true)) {
                // Sobrescribir el metodo para evitar el encabezado cuando estamos en append
                protected void writeStreamHeader() throws IOException {
                    // No hacemos nada para evitar que escriba el encabezado
                }
            }
                    : new ObjectOutputStream(new FileOutputStream(rutaArchivo));

            // Escribimos el objeto
            oos.writeObject(alumno);
            oos.close();  // Cerramos el flujo de salida
            System.out.println("Alumno guardado: " + alumno);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void leerAlumno(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            // Leemos todos los objetos hasta el final del archivo
            while (true) {
                Alumno alumno = (Alumno) ois.readObject();
                System.out.println("Alumno leído: " + alumno);
            }
        } catch (EOFException e) {
            // Fin del archivo alcanzado
            System.out.println("Fin del archivo.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
