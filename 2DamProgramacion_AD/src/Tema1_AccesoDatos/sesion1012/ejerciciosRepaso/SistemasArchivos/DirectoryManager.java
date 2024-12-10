package Tema1_AccesoDatos.sesion1012.ejerciciosRepaso.SistemasArchivos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectoryManager {

    public static void main(String[] args) {
        // TODO: Crear un objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        // TODO: Solicitar al usuario que introduzca la ruta de un directorio
        System.out.println("Introduce la ruta de un directorio:");

        // TODO: Leer la ruta ingresada por el usuario y almacenarla en una variable 'directoryPath'
        String directoryPath = sc.nextLine();
        // TODO: Crear un objeto File para el directorio proporcionado
        File directory = new File(directoryPath);
        // TODO: Verificar si el directorio es válido (existe y es un directorio)
        if (!isValidDirectory(directory)) {
            System.out.println("La ruta no corresponde a un directorio válido.");
            return;
        }

        // TODO: Obtener los archivos del directorio
        File[] files = getFiles(directory);

        // TODO: Mostrar un menú al usuario con las opciones:
        // 1. Ordenar archivos por nombre
        // 2. Ordenar archivos por tamaño
        // 3. Mostrar únicamente archivos con extensión específica
        System.out.println("Selecciona una opción:");
        System.out.println("1. Ordenar archivos por nombre");
        System.out.println("2. Ordenar archivos por tamaño");
        System.out.println("3. Filtrar archivos por extensión específica");

        // TODO: Leer la opción seleccionada por el usuario
        int opcion = sc.nextInt();
        sc.nextLine();
        // TODO: Implementar la funcionalidad según la opción seleccionada
        switch (opcion) {
            case 1: {
                sortByName(files); // - Si elige 1, ordenar los archivos por nombre
                break;
            }
            case 2: {
                sortBySize(files); // - Si elige 2, ordenar los archivos por tamaño
                break;
            }
            case 3: {
                System.out.println("Introduce la extensión del archivo:");
                String extension = sc.nextLine();
                files = filterByExtension(files, extension); // - Si elige 3, solicitar la extensión y mostrar solo los archivos que coincidan
                break;
            }
            default: {
                System.out.println("Opción no valida");
                return;
            }
        }
        // Mostrar los archivos después de realizar la acción
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No se encontraron archivos.");
        }
    }

    /**
     * Verifica si el directorio es válido.
     *
     * @param directory Directorio a verificar
     * @return true si es un directorio válido; false en caso contrario
     */
    private static boolean isValidDirectory(File directory) {
        // TODO: Verificar si el directorio existe y si es un directorio
        return directory.isDirectory() && directory.exists() ; // Cambiar este retorno cuando completes el TODO
    }

    /**
     * Obtiene los archivos de un directorio.
     *
     * @param directory Directorio del cual obtener los archivos
     * @return Array de archivos contenidos en el directorio
     */
    private static File[] getFiles(File directory) {
        // TODO: Devolver los archivos del directorio
        return directory.listFiles();
    }

    /**
     * Ordena los archivos por nombre.
     *
     * @param files Array de archivos a ordenar
     */
    private static void sortByName(File[] files) {
        // TODO: Implementar la lógica para ordenar los archivos por nombre
        Arrays.sort(files, (file1, file2) -> file1.getName().compareTo(file2.getName()));
    }

    /**
     * Ordena los archivos por tamaño.
     *
     * @param files Array de archivos a ordenar
     */
    private static void sortBySize(File[] files) {
        // TODO: Implementar la lógica para ordenar los archivos por tamaño
        Arrays.sort(files, (file1, file2) -> Long.compare(file1.length(), file2.length()));
    }

    /**
     * Filtra los archivos por una extensión específica.
     *
     * @param files Array de archivos a filtrar
     * @param extension Extensión deseada (por ejemplo, ".txt")
     * @return Array de archivos que cumplen con la extensión especificada
     */
    private static File[] filterByExtension(File[] files, String extension) {
        // TODO: Implementar la lógica para filtrar archivos por extensión
        return Arrays.stream(files)
                .filter(file -> file.getName().endsWith(extension))
                .toArray(File[]::new); // Cambiar este retorno cuando completes el TODO
    }
}

