package Tema1_AccesoDatos.sesion0911.DocumentosXML.Ejemplos.ejemploAlmacenamientoXML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class EscribirXML {
    public static void main(String[] args) {
        try {
            // Crear una instancia de un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un objeto DocumentBuilder a partir de la fábrica
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Crear un documento XML vacío
            Document document = builder.newDocument();

            // Crear el elemento raíz "estudiantes"
            Element rootElement = document.createElement("estudiantes");
            document.appendChild(rootElement);

            // Crear un estudiante (elemento <estudiante>)
            Element estudiante = document.createElement("estudiante");

            // Añadir los detalles del estudiante
            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Juan"));
            estudiante.appendChild(nombre);

            Element edad = document.createElement("edad");
            edad.appendChild(document.createTextNode("22"));
            estudiante.appendChild(edad);

            Element curso = document.createElement("curso");
            curso.appendChild(document.createTextNode("Programación"));
            estudiante.appendChild(curso);

            // Añadir el estudiante al elemento raíz
            rootElement.appendChild(estudiante);

            // Crear otro estudiante de ejemplo
            Element estudiante2 = document.createElement("estudiante");

            Element nombre2 = document.createElement("nombre");
            nombre2.appendChild(document.createTextNode("Ana"));
            estudiante2.appendChild(nombre2);

            Element edad2 = document.createElement("edad");
            edad2.appendChild(document.createTextNode("21"));
            estudiante2.appendChild(edad2);

            Element curso2 = document.createElement("curso");
            curso2.appendChild(document.createTextNode("Matemáticas"));
            estudiante2.appendChild(curso2);

            // Añadir el segundo estudiante al elemento raíz
            rootElement.appendChild(estudiante2);

            // Escribir el contenido en un archivo XML
            // Crear un TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Configurar la salida para que sea legible
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Crear un archivo donde se guardará el XML
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("estudiantes.xml");

            // Escribir el archivo XML
            transformer.transform(source, result);

            System.out.println("Archivo XML generado con éxito!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
