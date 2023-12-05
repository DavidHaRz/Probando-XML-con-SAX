/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.pkg5.mascomplejo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author David
 */
public class LibrosSAXhandler extends DefaultHandler{

    int contador = 0;
    
    public LibrosSAXhandler() {
    }

    //Se llama cuando empieza el documento
    @Override
    public void startDocument() throws SAXException {
        System.out.println("\tLISTADO DE LIBROS");
    }
    
    //Se llama cuando encuentra un elemento
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("book")){
            contador++;
            System.out.println("Libro nº" + contador);
            //Extrae el primer atributo
            System.out.println("Publicado en: " + attributes.getValue(attributes.getQName(0)));
        }else if (qName.equals("title"))
            System.out.println("\nEl título es: ");
            //Aún no sabemos cual es el título,
            //eso lo sabremos en el evento characters
        else if (qName.equals("author"))
            System.out.println("\nEl autor es: ");
    }

    //Se llama cuando termina un elemento
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("book "))
            System.out.println("\n----------------------------");
    }
    
    //Se llama cuando encuentra contenido dentro de un elemento
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //Convierte el contenido en una cadena        
        String car = new String (ch, start, length);
        car = car.replace("\t", "");    //Quita todos los tabuladores
        car = car.replace("\n", "");    //Quita todos los saltos de línea
        System.out.println(car);

    }
    
    
}
