package Tema1_AccesoDatos.sesion1012.ejemplosRepaso.SistemasArchivos;

import java.io.File;
import java.io.IOException;

public class ejemploSistemasArchivos {
    public static void main(String[] args) {
        // Crear un objeto File que apunte a un archivo llamado "ejemplo.txt"
        File file = new File("ejemplo.txt");

        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                System.out.println("El archivo no existe. Creándolo...");

                // Crear un archivo nuevo
                if (file.createNewFile()) {
                    System.out.println("Archivo creado exitosamente: " + file.getName());
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } else {
                System.out.println("El archivo ya existe.");
            }

            // Verificar si es un archivo
            if (file.isFile()) {
                System.out.println(file.getName() + " es un archivo.");
            }

            // Verificar si es un directorio
            if (file.isDirectory()) {
                System.out.println(file.getName() + " es un directorio.");
            }

            // Crear un directorio llamado "MiCarpeta"
            File directory = new File("MiCarpeta");
            if (!directory.exists()) {
                if (directory.mkdir()) {
                    System.out.println("Directorio creado: " + directory.getName());
                } else {
                    System.out.println("No se pudo crear el directorio.");
                }
            } else {
                System.out.println("El directorio ya existe.");
            }

            // Renombrar el archivo "ejemplo.txt" a "archivoRenombrado.txt"
            File renamedFile = new File("archivoRenombrado.txt");
            if (file.renameTo(renamedFile)) {
                System.out.println("Archivo renombrado a: " + renamedFile.getName());
            } else {
                System.out.println("No se pudo renombrar el archivo.");
            }

            // Verificar permisos del archivo
            System.out.println("¿Se puede leer? " + renamedFile.canRead());
            System.out.println("¿Se puede escribir? " + renamedFile.canWrite());
            System.out.println("¿Se puede ejecutar? " + renamedFile.canExecute());

            // Obtener el tamaño del archivo en bytes
            System.out.println("Tamaño del archivo: " + renamedFile.length() + " bytes");

            // Listar el contenido del directorio "MiCarpeta"
            String[] contenido = directory.list();
            if (contenido != null) {
                System.out.println("Contenido del directorio " + directory.getName() + ":");
                for (String item : contenido) {
                    System.out.println("- " + item);
                }
            } else {
                System.out.println("El directorio está vacío o no se pudo leer.");
            }

            // Eliminar el archivo renombrado
            if (renamedFile.delete()) {
                System.out.println("Archivo eliminado: " + renamedFile.getName());
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }

            // Eliminar el directorio "MiCarpeta" (debe estar vacío)
            if (directory.delete()) {
                System.out.println("Directorio eliminado: " + directory.getName());
            } else {
                System.out.println("No se pudo eliminar el directorio. Asegúrate de que esté vacío.");
            }

        } catch (IOException e) {
            // Capturar excepciones relacionadas con la creación del archivo
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
