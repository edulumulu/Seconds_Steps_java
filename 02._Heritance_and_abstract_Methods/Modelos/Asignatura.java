
package Modelos;

/**
 *Super clase Asignatura que contiene las variables de los parámetros generales 
 * de cada asignatura
 * @author eduardolucasmunozdelucas
 */
public abstract class Asignatura {
    private String nombre;  
    private int creditos;

    /**
     * Constructor de la clase Asignatura
     * @param nombre String
     * @param creditos Número entero
     */
    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    
    /*
    Conjunto de getters y setters de la clase Asignatura
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "nombre =  "+ nombre + " ;  total de creditos = " + creditos ;
        
    }
    
    /**
     * Método para utilizar el concepto de abstraccion en las clases hijas que pretende calcular precio total de créditos.
     * @return double
     */
    public abstract double calcularPrecioTotal();
    
    
    /**
     * Método para utilizar el concepto de abstraccion en las clases hijas que mostrará información de un objeto.
     * @param objeto
     * @return String
     */
    public abstract String mostrarInformacion(Object objeto);
    
     /**
     * Método para utilizar el concepto de abstraccion en las clases hijas que mostrará una serie de información.
     */
    public abstract void mostrarInformacion2();
    
}
