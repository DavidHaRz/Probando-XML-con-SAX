/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.pkg5.abriryrecorrerunxmlconsax;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author David
 */
public class AccesoXMLSAX {
    SAXParser parser;
    
    /**
     * Parsear XML con SAX para libros.
     * @param f Archivo donde se va a ejecutar.
     * @return 0 si funciona, 1 si falla.
     */
    public int parsearXMLconLibrosSAXhandler(File f){
        try{
            //Instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //Nuevo SAXParser
            parser = factory.newSAXParser();
            //Objeto de tipo libros
            LibrosSAXhandler sh = new LibrosSAXhandler();
            //Parsea el XML con el archivo y el objeto de tipo libros
            parser.parse(f, sh);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }
    
    /**
    * Parsear XML con SAX para titulos.
    * @param f Archivo donde se va a ejecutar.
    * @return 0 si funciona, 1 si falla.
    */
    public int parsearXMLconTitulosSAXhandlerI(File f){
        try {
            //Instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //Nuevo SAXParser
            parser = factory.newSAXParser();
            //Objeto de tipo titulos
            TitulosSAXhandler sh = new TitulosSAXhandler();
            //Parsea el XML con el archivo y el objeto de tipo titulos
            parser.parse(f, sh);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
