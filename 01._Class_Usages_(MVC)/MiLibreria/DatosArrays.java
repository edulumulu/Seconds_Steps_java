/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiLibreria;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class DatosArrays {
    
    /**
     * Este método verifica si el array esta completo (true) o no lo está (false).
     * Reliza el bucle mientras i sea mayor que la longitud del array y la booleana sea true.
     * @param obj ---> Array de "Objetos"???
     * @return ---> Retorna un true en caso de estar lleno y un false si no lo está.
     */
    public static boolean estaLleno(Object [] obj) {
        boolean lleno = true;
        for (int i = 0 ; i < obj.length && lleno ; i++){
            if(obj[i] == null){
                lleno = false;
            }
        }
        return lleno;
    }    
    
    /**
     * Este método verifica si el array esta vacio (true) o no lo está (false).
     * Realiza el bucle mientras i sea mayor que la longitud del array y la booleana sea true.
     * @param obj ---> Array de "Objetos"???
     * @return ---> Retorna un true en caso de estar vacio y un false si no lo está.
     */
    public static boolean estaVacio (Object [] obj){
       boolean vacio = true;
       for(int i = 0 ; i < obj.length && vacio ; i++){
           if(obj[i] != null){
               vacio = false;
           }
       }
        return vacio;
    }
    
    /**
     * Este método obtiene la primera posicion libre del array introducido. 
     * Realiza el bucle mientras i sea mayor que la longitud del array y el valor de la posición no sea modificada.
     * @param obj
     * @return ---> Retorna un entero (la posición de la priemra posición libre del array.
     */
    public static int primeraPosicionLibre (Object [] obj){
        int posicion = -1;
        for(int i = 0 ; i < obj.length && posicion ==-1; i++){
            if(obj [i] == null){
                posicion = i;
            }
        }
        return posicion;
    }
    
 
    
}
