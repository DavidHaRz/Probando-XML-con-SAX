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
    
    public int parsearXMLconLibrosSAXhandler(File f){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            LibrosSAXhandler sh = new LibrosSAXhandler();
            parser.parse(f, sh);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }
    
    public int parsearXMLconTitulosSAXhandlerI(File f){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            TitulosSAXhandler sh = new TitulosSAXhandler();
            parser.parse(f, sh);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
