/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema1_AccesoDatos.sesion0911.DocumentosXML.Ejercicios.MonacoF1_XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import Tema1_AccesoDatos.sesion0911.DocumentosXML.Ejercicios.MonacoF1_XML.Driver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 * 
 * <Result number="44" position="7" positionText="7" points="6">
 * <Driver driverId="hamilton" code="HAM" url=
 * "http://en.wikipedia.org/wiki/Lewis_Hamilton">
 * <PermanentNumber>44</PermanentNumber> <GivenName>Lewis</GivenName>
 * <FamilyName>Hamilton</FamilyName> <DateOfBirth>1985-01-07</DateOfBirth>
 * <Nationality>British</Nationality> </Driver>
 * <Constructor constructorId="mercedes" url=
 * "http://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One">
 * <Name>Mercedes</Name> <Nationality>German</Nationality> </Constructor>
 * <Grid>13</Grid> <Laps>78</Laps> <Status statusId="1">Finished</Status>
 * <Time millis="6300141">+15.801</Time> <FastestLap rank="5" lap="54">
 * <Time>1:15.825</Time> <AverageSpeed units="kph">158.433</AverageSpeed>
 * </FastestLap> </Result>
 */
public class ResultadoCarrera_alumnos {
	private Driver d;
	private String constructor;
	private int initialPos;
	private int finalPos;
	private long timeMillis;
	private int completedLaps;
	private int rankFastesLap;
	private boolean finisher;

	public static void main(String[] args) {
		// Definir la ruta del archivo XML, en este caso "monaco_2017.xml"
		String rutaArchivo = "C://Users//Iker//Documents//2DamProgramacion_AD-master//2DamProgramacion_AD//src//Tema1_AccesoDatos//sesion0911//DocumentosXML//Ejercicios//MonacoF1_XML//monaco_2017.xml";

		try {
			// Crear una instancia de DocumentBuilderFactory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			// Crear un DocumentBuilder a partir de dbFactory
			DocumentBuilder db = dbf.newDocumentBuilder();

			// Cargar y analizar el archivo XML especificado por xmlFilePath
			Document doc = db.parse(new File(rutaArchivo));

			// Normalizar el contenido del documento XML
			doc.normalize();

			// Obtener la lista de elementos "Result" del XML
			NodeList resultList = doc.getElementsByTagName("Result");

			// Iterar sobre cada elemento "Result" en resultList
			for (int i = 0; i < resultList.getLength(); i++) {
				// Obtener el elemento "Result" actual de resultList
				Element resultElement = (Element) resultList.item(i);

				// Crear una instancia de ResultadoCarrera_alumnos utilizando el elemento resultElement
				ResultadoCarrera_alumnos resultado = new ResultadoCarrera_alumnos(resultElement);

				// Imprimir el resultado utilizando el metodo toString()
				System.out.println(resultado.toString());
			}
		} catch (Exception e) {
			// Imprimir un mensaje de error si ocurre una excepción al procesar el archivo XML
			e.printStackTrace();
		}
	}

	public ResultadoCarrera_alumnos(Element result) {
		try {
			// Obtener el elemento "Driver" de result y extraer "GivenName" y "FamilyName"
			Element driverElement = (Element) result.getElementsByTagName("Driver").item(0);

			// Crear una instancia de Driver usando driverElement
			this.d = new Driver(driverElement);

			// Obtener el nombre del "Constructor" del coche
			Element constructorElement = (Element) result.getElementsByTagName("Constructor").item(0);
			this.constructor = constructorElement.getElementsByTagName("Name").item(0).getTextContent();

			// Obtener la posición inicial en la parrilla de salida
			this.initialPos = Integer.parseInt(result.getElementsByTagName("Grid").item(0).getTextContent());

			// Obtener la posición final de la carrera a partir del atributo "position"
			this.finalPos = Integer.parseInt(result.getAttribute("position"));

			// Obtener la cantidad de vueltas completadas
			this.completedLaps = Integer.parseInt(result.getElementsByTagName("Laps").item(0).getTextContent());

			// Obtener el tiempo total en milisegundos (si existe)
			Element timeElement = (Element) result.getElementsByTagName("Time").item(0);
			if (timeElement != null) {
				this.timeMillis = Long.parseLong(timeElement.getAttribute("millis"));
			}

			// Obtener el rango de la vuelta rápida (si existe)
			Element fastestLapElement = (Element) result.getElementsByTagName("FastestLap").item(0);
			if (fastestLapElement != null) {
				this.rankFastesLap = Integer.parseInt(fastestLapElement.getAttribute("rank"));
			}

			// Comprobar si el piloto terminó la carrera ("statusId" igual a "1")
			Element statusElement = (Element) result.getElementsByTagName("Status").item(0);
			this.finisher = statusElement.getAttribute("statusId").equals("1");

		} catch (Exception e) {
			// Imprimir la traza de la excepción si ocurre un error
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String resul = "Resultado de Carrera:\n\t" + d.getName() + " " + d.getSurname() + " conduciendo un "
				+ constructor + "\n\tParte de la posicion: " + initialPos + " y termina en la " + finalPos
				+ "\n\tHa completado " + completedLaps + " vueltas";
		if (this.finisher)
			resul += " tardando " + toHHMMSSmmm(timeMillis);
		else
			resul += " sin completar la carrera";

		resul += "\n\tSu clasificación en vuelta rápida personal=" + rankFastesLap;
		return resul;
	}

	public static String toHHMMSSmmm(long millis) {
		long mmm = millis % 1000;
		long seconds = millis / 1000;
		long s = seconds % 60;
		long m = (seconds / 60) % 60;
		long h = (seconds / (60 * 60)) % 24;
		return String.format("%02d:%02d:%02d:%03d", h, m, s, mmm);
	}

	public Driver getD() {
		return d;
	}

	public String getConstructor() {
		return constructor;
	}

	public int getInitialPos() {
		return initialPos;
	}

	public int getFinalPos() {
		return finalPos;
	}

	public long getTimeMillis() {
		return timeMillis;
	}

	public int getCompletedLaps() {
		return completedLaps;
	}

	public int getRankFastesLap() {
		return rankFastesLap;
	}

	public boolean isFinisher() {
		return finisher;
	}
}
