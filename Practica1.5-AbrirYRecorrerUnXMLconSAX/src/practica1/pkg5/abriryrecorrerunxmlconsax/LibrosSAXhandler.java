/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.pkg5.abriryrecorrerunxmlconsax;

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

    @Override
    public void startDocument() throws SAXException {
        System.out.println("\tLISTADO DE LIBROS");
    }
    
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("Libro")){
            contador++;
            System.out.println("Libro nº" + contador);
            System.out.println("Publicado en: " + attributes.getValue(attributes.getQName(0)));   //Extrae el primer atributo
        }else if (qName.equals("Titulo"))
            System.out.println("\nEl título es: ");     //Aún no sabemos cual es el título,
            //eso lo sabremos en el evento characters
        else if (qName.equals("Autor"))
            System.out.println("\nEl autor es: ");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("Libro"))
            System.out.println("\n----------------------------");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String (ch, start, length);
        car = car.replace("\t", "");    //Quita todos los tabuladores
        car = car.replace("\n", "");    //Quita todos los saltos de línea
        System.out.println(car);

    }
    
    
}
