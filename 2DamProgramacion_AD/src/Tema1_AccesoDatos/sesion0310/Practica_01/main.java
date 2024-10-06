package Tema1_AccesoDatos.sesion0310.Practica_01;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    // Utilizamos estas variables estáticas para poder trabajar de manera global en la clase Main y utilizarlas para ahorrar código
    private static File rutaFija = new File("videojuegos.json"); // Crear el archivo JSON en una ruta fija
    private static List<Videojuego> videojuegos = new ArrayList<>(); // Crear ArrayList para poder almacenarlo en el archivo JSON
    private static Gson gson = new Gson(); // Utilizamos la librería gson de Google para poder transformar un ArrayList a un archivo JSON
    private static Scanner sc = new Scanner(System.in); // Utilizaremos el Scanner para que el usuario pueda introducir por pantalla los datos

    public static void main(String[] args) {

        // Utilizaremos para empezar el método cargarVideojuego para poder iniciar la aplicación
        cargarVideojuego(rutaFija);

        boolean salir = false; // Utilizaremos esta variable boolean inicializada en false para poder cerrar el programa a través del switch para el menu


        while (!salir) { // Esto significa que mientras que no salgamos del programa podremos seguir utilizando el programa en forma de bucle, pero si salimos se acabará el bucle y cerrará el programa
            System.out.println("¡Bienvenido a OLLIS COLLECTIONS!");
            System.out.println("¿Qué es OLLIS COLLECTIONS? Es un sitio para poder colecionar y guardar tus videojuegos favoritos. ¿A qué esperas? ¡Empieza a coleccionar tus videojuegos favoritos!");
            System.out.println("Menu:");
            System.out.println("Elige una opcion:");
            System.out.println("1. Mostrar videojuego");
            System.out.println("2. Añadir videojuego");
            System.out.println("3. Actualizar videojuego");
            System.out.println("4. Eliminar videojuego");
            System.out.println("5. Busqueda avanzada");
            System.out.println("6. Guardar");
            System.out.println("7. Guardar como");
            System.out.println("8. Cambiar ruta");
            System.out.println("9. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    mostrarVideojuegos();
                    break;
                }
                case 2: {
                    añadirVideojuego();
                    break;
                }
                case 3: {
                    actualizarVideojuego();
                    break;
                }
                case 4: {
                    eliminarVideojuego();
                    break;
                }
                case 5: {
                    buscarAvanzada();
                    break;
                }
                case 6: {
                    guardarVideojuegos(rutaFija);
                    break;
                }
                case 7: {
                    guardarComo();
                    break;
                }
                case 8: {
                    cambiarRuta();
                    break;
                }
                case 9: {
                    System.out.println("¡Gracias por utilizar OLLIS COLLECTIONS!");
                    salir = true;
                    break;
                }
                default: {
                    System.out.println("Error. Seleccione una opción válida");
                }
            }
        }
    }

    // Método cargarVideojuegos: cargar videojuegos desde un archivo JSON
    private static void cargarVideojuego(File file) {

        if (!file.exists()) { // Verificación de si no existe el archivo, te crea uno nuevo
            System.out.println("No existe el archivo, se creará uno nuevo");
            guardarVideojuegos(file);
            return;
        }
        try (Reader leer = new FileReader(file)) {
            videojuegos = gson.fromJson(leer, new TypeToken<List<Videojuego>>() {}.getType());
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + file.getName());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método mostrarVideojuegos: mostrar todos los videojuegos que hemos guardado
    private static void mostrarVideojuegos() {
        if (videojuegos.isEmpty()) {
            System.out.println("No existe el videojuego"); // si el videojuego no existe y no puede mostrarlo que nos ponga un mensaje en consola que no existe ese videojuego
        } else {
            for (Videojuego v : videojuegos) { //for-each: recorremos el array de videojuegos
                System.out.println(v);
            }
        }
    }

    //Método añadirVideojuego: añadir videojuegos mediante la instanciación del objeto Videojuego y añadirlos al Arraylist para guardarlo en el archivo JSON
    private static void añadirVideojuego() {

        sc.nextLine();

        System.out.println("Titulo: ");
        String titulo = sc.nextLine();

        System.out.println("Lanzamiento: ");
        int lanzamiento = sc.nextInt();
        sc.nextLine();

        System.out.println("Plataforma: ");
        String plataforma = sc.nextLine();

        System.out.println("Precio: ");
        float precio = sc.nextFloat();
        sc.nextLine();
        if (precio < 0) { // Verificacion de si se da el caso de que el usuario introduzca un numero negativo
            System.out.println("El precio no puede ser negativo");
            return;
        }

        System.out.println("Imagen: ");
        String imagen = sc.nextLine();

        Videojuego videojuego = new Videojuego(titulo, lanzamiento, plataforma, precio, imagen);
        videojuegos.add(videojuego);
        guardarVideojuegos(rutaFija); // Guardar los datos del videojuego en el JSON
        System.out.println("Videojuego añadido");
    }

    //Método buscarVideojuegoPorTitulo: buscar un videojuego específico donde se encuentre en el ArrayList utilizando solo el titulo de ese videojuego
    private static Videojuego buscarVideojuegoPorTitulo(String titulo) {
        for (Videojuego v : videojuegos) {
            if (v.getTitulo().equalsIgnoreCase(titulo)) { // Si encuentra el título del juego devuelve el videojuego, si no lo encuentra, devuelve un null
                return v;
            }
        }
        return null;
    }

    // Método actualizarVideojuego: actualizar un videojuego mediante el uso del método buscarVideojuegoPorTitulo para actualizar el videojuego mediante poniendo el título del juego
    private static void actualizarVideojuego() {
        sc.nextLine();

        System.out.println("Introduce qué videojuego quieres actualizar: ");
        String titulo = sc.nextLine();
        Videojuego videojuego = buscarVideojuegoPorTitulo(titulo);
        if (videojuego != null) { // Si el videojuego si se encuentra y lo retorna, le actualizaremos su precio por uno nuevo y luego volveremos a guardar los datos del videojuego tanto en el ArrayList como en el archivo JSON, pero si no se encuentra, mostraremos un mensaje de que no se ha podido encontrar
            System.out.println("Nuevo precio: ");
            float precio = sc.nextFloat();
            videojuego.setPrecio(precio);
            guardarVideojuegos(rutaFija);
            System.out.println("Videojuego actualizado");
        } else {
            System.out.println("Videojuego no encontrado");
        }
    }

    //Método eliminarVideojuego: eliminar un videojuego mediante el uso del método buscarVideojuegoPorTitulo para poder eliminar el videojuego mediante el título del juego
    private static void eliminarVideojuego() {
        sc.nextLine();

        System.out.println("Introduce qué videojuego quieres eliminar: ");
        String titulo = sc.nextLine();
        Videojuego videojuego = buscarVideojuegoPorTitulo(titulo);
        if (videojuego != null) { // Pasa lo mismo que en el método actualizarVideojuego, pero en este caso eliminamos el videojuego mediante la funcion del ArrayList remove(), en la cual, eliminamos o removemos todos los datos guardados del ArrayList videojuegos y a su vez eliminamos también los datos del archivo JSON de ese videojuego
            videojuegos.remove(videojuego);
            guardarVideojuegos(rutaFija);
            System.out.println("Videojuego eliminado");
        } else {
            System.out.println("Videojuego no encontrado");
        }
    }

    // Método busquedaAvanzada: realizar busquedas de videojuegos mediante el titulo, el lanzamiento y la plataforma
    private static List<Videojuego> busquedaAvanzada(String titulo, Integer lanzamiento, String plataforma) { // Debemos de devolver el ArrayList del objeto Videojuegos, ya que solo queremos que devuelva el titulo, el lanzamiento y la plataforma
        List<Videojuego> busqueda = new ArrayList<>();
        for (Videojuego v : videojuegos) { // Recorremos el ArrayList
            boolean coincidencia = true; // Esta variable la inicializamos en True y la utilizamos para poder saber si el videojuego esta cumpliendo los requisitos de la busqueda
            if (titulo != null && !v.getTitulo().equalsIgnoreCase(titulo)) { // Verificacion de sí el videojuego indicado cumple o no el criterio de busqueda por título
                coincidencia = false;
            }
            if (lanzamiento != null && v.getLanzamiento() != lanzamiento) { // Verificacion de sí el videojuego indicado cumple o no el criterio de busqueda por lanzamiento
                coincidencia = false;
            }
            if (plataforma != null && !v.getPlataforma().equalsIgnoreCase(plataforma)) { // Verificación de sí el videojuego indicado cumple o no el criterio de busqueta por año
                coincidencia = false;
            }
            if (coincidencia) { // Si el videojuego cumple todos los requisitos de busqueda, entonces se le añadirá a la lista de busqueda
                busqueda.add(v);
            }
        }
        return busqueda;
    }

    // Método guardarVideojuegos: guardar un videojuego en un archivo JSON
    private static void guardarVideojuegos(File file) {
        try (Writer escribir = new FileWriter(file)) {
            gson.toJson(videojuegos, escribir);
            System.out.println("Los datos fueron guardados correctamente en: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método guardarComo: guardar el videojuego en la ruta que quiera el usuario
    private static void guardarComo() {
        sc.nextLine();

        System.out.println("Introduce la ruta del archivo para guardar: ");
        String ruta = sc.nextLine();
        File archivo = new File(ruta);
        guardarVideojuegos(archivo);
    }

    // Método cambiarRuta: cambiar la ruta y que lo eliga el usuario
    private static void cambiarRuta() {

        sc.nextLine();
        System.out.println("Introduce la nueva ruta fija: ");
        String ruta = sc.nextLine();
        rutaFija = new File(ruta);
        System.out.println("La ruta ha sido cambiada a: " + rutaFija.getAbsolutePath());

    }

    // Método buscarAvanzada: permitir al usuario realizar una busqueda de los videojuegos utilizando varios requisitos de busqueda como el titulo, la plataforma o el año
    private static void buscarAvanzada() {
        sc.nextLine();

        System.out.println("Introduce el título: ");
        String titulo = sc.nextLine();

        System.out.println("Introduce la plataforma: ");
        String plataforma = sc.nextLine();

        System.out.println("Introduce el lanzamiento: ");
        String lanzamientoTxt = sc.nextLine();


        Integer lanzamiento = lanzamientoTxt.isEmpty() ? null : Integer.parseInt(lanzamientoTxt); // Esto significa que si el usuario deja en blanco el lanzamiento. no se usará como requisito de busqueda. A parte de que debemos parsear el lanzamientoTxt a un Integer, es decir, necesitamos utilizar el tipo de dato envoltorio de int (Integer) para poder convertir de una cadena de texto (String) a un entero (int). Por ello utilizamos el parse

        List<Videojuego> lista = busquedaAvanzada(titulo, lanzamiento, plataforma); // LLamada al método busquedaAvanzada para poder pasar los parámetros de titulo, lanzamiento y plataforma, devolviendo el ArrayList de esos valores que cumplar los requisitos de busqueda

        if (lista.isEmpty()) { // Verificacion de si la lista esta vacia, es decir, si la lista no hay nada, no se cumple los requisitos de la busqueda
            System.out.println("No se han encontrado los videojuegos que coincidan con los requisitos de busqueda");
        } else {
            System.out.println("Resultados de la busqueda: ");
            for (Videojuego v : lista) { // Recorremos el ArrayList
                System.out.println(v);
            }
        }
    }

}





