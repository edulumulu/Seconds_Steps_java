
package Modelos;

/**
 * Clase hija de la super clase Asignatura
 * @author eduardolucasmunozdelucas
 */
public class Programacion extends Asignatura{
    
    private String lenguaje;
    private String nivel;

    /**
     * Constructor de la clase Programación.
     * @param lenguaje
     * @param nivel
     * @param nombre
     * @param creditos 
     */
    public Programacion(String lenguaje, String nivel, String nombre, int creditos) {
        super(nombre, creditos);
        this.lenguaje = lenguaje;
        this.nivel = nivel;
    }

    /**
     * Método sobreescrito de la clase Asignatura. Devuelve un String compuesto de una concatenación de Strings
     * @return String
     */
    @Override
    public String toString() {
        return super.toString()+ " ---> (Programación con: lenguaje = " + lenguaje + "; nivel = " + nivel +")" ;
    }

    
     /**
     * Metodo heredado y sobreescrito de la clase Asignatura que calcula el precio del total de creditos del objeto Programación.
     * @return double
     */
    @Override
    public double calcularPrecioTotal() {
        double precioCredito = 8.5;
        double precioTotal = this.getCreditos() * precioCredito;
        return precioTotal;
        
//        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     /**
     * Método heredado y sobrescrito que imprime la información de los objetos Programación.
     */
    @Override
    public void mostrarInformacion2() {
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Créditos: "+this.getCreditos());
        System.out.println("Nivel: "+getNivel());
        System.out.println("Lenguaje: "+ getLenguaje());
        System.out.println("Precio : "+calcularPrecioTotal()+" €");
         
    }

    /**
     * Metodo heredado y sobreescrito de la clase Asignatura que recibe un objeto de parametro y devuelve un String
     * @param objeto
     * @return String
     */
    @Override
    public String mostrarInformacion(Object objeto) {
        return objeto.toString();
    }

    
    /*
    Conjunto de getters y setters de la clase Programación
    */
    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    
    
    
}
