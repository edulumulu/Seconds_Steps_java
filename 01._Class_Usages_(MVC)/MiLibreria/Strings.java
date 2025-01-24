/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiLibreria;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Strings {
    
    /**
     * Metodo que verifica que el texto introducido como parámetro tenga una longitud mayor que 0
     * @param t ---> String
     * @return ---> true o false
     */
    public static boolean palabraVacia(String t) {
        boolean si = t.length() == 0;
        if (si) {
            System.out.println("String vacío, intentalo de nuevo:");
//            si= false;
        }
        return si;
    }
    
    
}
