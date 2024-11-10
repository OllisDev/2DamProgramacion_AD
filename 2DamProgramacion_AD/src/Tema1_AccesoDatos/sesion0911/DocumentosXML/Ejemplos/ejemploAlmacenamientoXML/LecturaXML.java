package Tema1_AccesoDatos.sesion0911.DocumentosXML.Ejemplos.ejemploAlmacenamientoXML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LecturaXML {
    public static void main(String[] args) {
        try {
            // Crear una instancia de un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un objeto DocumentBuilder a partir de la fábrica
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Leer el archivo XML (en este caso, estudiantes.xml)
            File archivoXML = new File("estudiantes.xml");
            Document document = builder.parse(archivoXML);

            // Normalizar el documento para evitar problemas con el formato
            document.getDocumentElement().normalize();

            // Obtener el nodo raíz del documento (en este caso, <estudiantes>)
            Element rootElement = document.getDocumentElement();
            System.out.println("Elemento raíz: " + rootElement.getNodeName());

            // Obtener todos los nodos <estudiante> dentro de la raíz
            NodeList nodeList = document.getElementsByTagName("estudiante");

            // Recorrer todos los nodos <estudiante>
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Obtener el nodo individual <estudiante>
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Convertir el nodo a un elemento
                    Element estudiante = (Element) node;

                    // Extraer los datos del estudiante
                    String nombre = estudiante.getElementsByTagName("nombre")
                            .item(0)
                            .getTextContent();
                    String edad = estudiante.getElementsByTagName("edad")
                            .item(0)
                            .getTextContent();
                    String curso = estudiante.getElementsByTagName("curso")
                            .item(0)
                            .getTextContent();

                    // Mostrar los datos del estudiante en la consola
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Curso: " + curso);
                    System.out.println("--------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Clases y metodos del DOM

- Document -> nodo principal y representa el XML
- Element -> elementos representados del documento XML
- TextElement -> contenido del elemento
- Attribute -> atributos de los elementos
 */

// item() -> acceder a una posicion del elemento
// getElementByTagName() -> devolver todos los nodos de un elemento especifico