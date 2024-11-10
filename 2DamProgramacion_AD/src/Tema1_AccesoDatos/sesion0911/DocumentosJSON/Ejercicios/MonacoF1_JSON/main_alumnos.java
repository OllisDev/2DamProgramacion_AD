package Tema1_AccesoDatos.sesion0911.DocumentosJSON.Ejercicios.MonacoF1_JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;

public class main_alumnos {
    public static void main(String[] args) {
    	// TODO: Definir la ruta del archivo JSON como un String
		String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//DocumentosJSON//Ejercicios//MonacoF1_JSON//monaco.json";
		// TODO: Crear un FileInputStream para leer el archivo JSON
    	try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
    	    // TODO: Crear un JSONTokener utilizando el FileInputStream
			JSONTokener jt = new JSONTokener(fis);
    	    // TODO: Crear un JSONObject a partir del JSONTokener
			JSONObject jo = new JSONObject(jt);
    	    // TODO: Obtener el objeto "race" del JSON principal
			JSONObject race = jo.getJSONObject("race");
    	    // TODO: Obtener el objeto "results" dentro de "race"
			JSONObject results = race.getJSONObject("results");
    	    // TODO: Obtener el array "result" dentro de "results"
			JSONArray resultList = results.getJSONArray("result");
    	    // TODO: Iterar sobre cada elemento del array "result"
    	    for (int i = 0; i < resultList.length(); i++) {
    	        // TODO: Obtener el objeto "result" en la posición actual del array
				JSONObject result = (JSONObject) resultList.get(i);
    	        // TODO: Obtener el valor "position" como un entero
				int position = result.getInt("position");
    	        // TODO: Obtener el objeto "Driver" dentro de "result"
				JSONObject driver = result.getJSONObject("Driver");
    	        // TODO: Obtener el nombre y apellido del conductor y combinarlos en una cadena
				String givenName = driver.getString("GivenName");
				String familyName = driver.getString("FamilyName");
				String combinated = givenName + " " + familyName;
    	        // TODO: Obtener la nacionalidad del conductor
				String nacionality = driver.getString("Nationality");
    	        // TODO: Obtener el objeto "Constructor" dentro de "result"
				JSONObject constructor = result.getJSONObject("Constructor");
    	        // TODO: Obtener el nombre del equipo
				String name = constructor.getString("Name");
    	        // TODO: Obtener el valor "Grid" como un String
				String grid = result.getString("Grid");
    	        // TODO: Obtener el valor "Laps" como un String
				String laps = result.getString("Laps");
    	        // TODO: Obtener el tiempo total desde el objeto "Time" en formato de texto
				JSONObject time = result.optJSONObject("Time");
				String timeTotal = (time != null) ? time.optString("millis", "N/A") : "N/A";
    	        // TODO: Obtener el tiempo de la vuelta más rápida desde "FastestLap"
				JSONObject fastestLap = result.optJSONObject("FastestLap");
				String lapTime = (fastestLap != null) ? fastestLap.optString("lapTime", "N/A") : "N/A";
    	        // TODO: Imprimir los datos del resultado en el formato indicado
				System.out.println("Posición: " + position);
				System.out.println("Nombre completo: " + combinated);
				System.out.println("Nacionalidad " + nacionality);
				System.out.println("Equipo " + name);
				System.out.println("Posición: " + grid);
				System.out.println("Vueltas: " + laps);
				System.out.println("Tiempo total: " + timeTotal);
				System.out.println("Vuelta más rápida: " + fastestLap);
    	    }

    	} catch (IOException e) {
    	    // TODO: Manejar la excepción si ocurre un error al leer el archivo
			e.printStackTrace();
			System.out.println("No se ha podido leer el fichero JSON");
    	}
    }
}
