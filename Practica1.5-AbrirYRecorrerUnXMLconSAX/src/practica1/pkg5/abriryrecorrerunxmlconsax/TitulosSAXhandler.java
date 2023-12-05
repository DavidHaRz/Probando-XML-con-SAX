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
public class TitulosSAXhandler extends DefaultHandler {

    private String etiqueta;

    public TitulosSAXhandler() {
        etiqueta = "";  //También se puede hacer con int etiqueta
    }

    //Se llama cuando empieza el documento
    @Override
    public void startDocument() {
        System.out.println("LISTADO DE TITULOS");
        System.out.println("===================");
    }

    //Se llama cuando encuentra un elemento
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Libro"))
            etiqueta = "Libro";
        else if (qName.equals("Titulo"))
            etiqueta = "Titulo";
        else if (qName.equals("Autor"))
            etiqueta = "Autor";
    }

    //Se llama cuando encuentra contenido dentro de un elemento
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (etiqueta.equals("Titulo") || etiqueta.equals("Autor")){
            //Convierte el contenido en una cadena
            String car = new String(ch, start, length);
            car = car.replaceAll("\t", ""); //Quita todos los tabuladores
            car = car.replaceAll("\n", ""); //Quita todos los saltos de línea
            //car = car.replaceAll("[\t\n]", "");   //Hace lo mismo que la dos líneas anteriores
            if (etiqueta.equals("Titulo"))
                System.out.print(car + ", ");
            else if (etiqueta.equals("Autor"))
                System.out.println(car + "\n");
        }    
    }
    
}
