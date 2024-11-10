package Tema1_AccesoDatos.sesion0911.FicherosBinarios.Ejemplos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ejemploGuardarTextoBinario {
    public static void main(String[] args) {
        // Texto que queremos guardar en formato binario
        String texto = "Este es un ejemplo de guardar texto en un archivo binario.";

        // Ruta del archivo binario donde guardaremos el texto
        String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//FicherosBinarios//Ejemplos//EjemplostextoGuardado.bin";

        // Llamamos al metodo para guardar el texto en formato binario
        guardarTextoBinario(rutaArchivo, texto);
    }

    // Metodo que guarda el texto en un archivo binario
    private static void guardarTextoBinario(String rutaArchivo, String texto) {
        // Usamos FileOutputStream para abrir un archivo y escribir en él en formato binario
        try (FileOutputStream fos = new FileOutputStream(rutaArchivo);  // Abrimos el archivo para escritura
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {  // ObjectOutputStream para convertir objetos a formato binario

            // Escribimos el texto en el archivo binario
            oos.writeObject(texto);

            // Confirmamos que se guardó el texto con éxito
            System.out.println("Texto guardado en formato binario en: " + rutaArchivo);

        } catch (IOException e) {
            // Si ocurre algún error, lo manejamos e imprimimos el mensaje de error
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}

