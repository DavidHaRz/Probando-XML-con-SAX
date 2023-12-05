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
        if (qName.equals("book")) {
            etiqueta = "book ";
        } else if (qName.equals("title")) {
            etiqueta = "title";
        } else if (qName.equals("author")) {
            etiqueta = "author";
        } else if (qName.equals("genre")) {
            etiqueta = "genre";
        } else if (qName.equals("price")) {
            etiqueta = "price";
        } else if (qName.equals("publish_date")) {
            etiqueta = "publish_date";
        } else if (qName.equals("description")) {
            etiqueta = "description";
        }
    }
        
    //Se llama cuando encuentra contenido dentro de un elemento
    //Creo un array de tamaño 2 para cambiar el orden a la hora de mostrar
    String[] datos = new String[2];
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (etiqueta.equals("title") || etiqueta.equals("author")) {
            String car = new String(ch, start, length);
            car = car.replaceAll("\t", ""); //Quita todos los tabuladores
            car = car.replaceAll("\n", ""); //Quita todos los saltos de línea
            //car = car.replaceAll("[\t\n]", "");   //Hace lo mismo que la dos líneas anteriores
            
            if (etiqueta.equals("author"))
                datos[0] = car;
            else{
                datos[1] = car;
                
                System.out.println(datos[1] + " --- " + datos[0]);
            }
        }
        
        /*
        if (etiqueta.equals("title")) {
            String car = new String(ch, start, length);
            car = car.replaceAll("\t", ""); //Quita todos los tabuladores
            car = car.replaceAll("\n", "");
            System.out.println(car);
        }
        if (etiqueta.equals("author")) {
            String car = new String(ch, start, length);
            car = car.replaceAll("\t", ""); //Quita todos los tabuladores
            car = car.replaceAll("\n", "");
            System.out.println(car);
        }
        */
        
        /*
        String titulo = "";
            String autor = "";
            if (etiqueta.equals("author")) {
                autor = car;
            } else if (etiqueta.equals("title")) {
                titulo = car;
                System.out.println(titulo + " --- " + autor);
            }
        */
    }

}
