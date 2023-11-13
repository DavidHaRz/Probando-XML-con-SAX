/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1.pkg5.abriryrecorrerunxmlconsax;

import java.io.File;

/**
 *
 * @author David
 */
public class UsaAccesoXMLSAX {
    
    public static void main(String[] args){
        File f = new File ("Libros.xml");
        AccesoXMLSAX a = new AccesoXMLSAX();
        //a.parsearXMLconLibrosSAXhandler(f);
        a.parsearXMLconTitulosSAXhandlerI(f);
    }
}
