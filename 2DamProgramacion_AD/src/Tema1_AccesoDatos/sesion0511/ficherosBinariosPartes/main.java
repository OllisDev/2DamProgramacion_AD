package Tema1_AccesoDatos.sesion0511.ficherosBinariosPartes;

import java.io.*;
import java.util.Scanner;

public class main {
    public static void guardarAlumno(Alumno alumno) {
        // Utilizamos DataOutputStream para poder guardar los datos por atributos de nuestra clase Alumno a un fichero binario(Alumno.dat)
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Alumno.dat"))) {
            // Escribimos cada uno de los datos de la clase Alumno
            dos.writeUTF(alumno.getNombre()); // writeUTF(): escribir cadenas de texto
            dos.writeInt(alumno.getEdad()); // writeInt(): escribir numeros enteros
            dos.writeUTF(alumno.getCurso());
            System.out.println("Datos guardados correctamente en Alumno.dat");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static void leerAlumno() {
        // Utilizamos DataInputStream para poder leer los datos por atributos de la clase Alumno mediante el fichero binario que hemos guardado
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Alumno.dat"))) {
            // Leemos cada uno de los datos guardados del fichero binario
           String nombre = dis.readUTF(); // readUTF(): leer cadenas de texto
           int edad = dis.readInt(); // readInt(): leer numeros enteros
           String curso = dis.readUTF();
            // Mostramos por pantalla los datos que está leyendo del archivo binario
            System.out.println("Datos leidos del archivo:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Curso: " + curso);

        } catch (IOException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la edad del alumno:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el curso del alumno:");
        String curso = sc.nextLine();

        guardarAlumno(new Alumno(nombre, edad, curso)); // Llamamos al metodo GuardarAlumno para instanciar un objeto de la clase Alumno y guardar los datos introducidos por teclado del usuario en el archivo binario
        leerAlumno(); // LLamamos al metodo leerAlumno para leer cada uno de los datos guardados por el usuario dentro del archivo binario
    }
}
