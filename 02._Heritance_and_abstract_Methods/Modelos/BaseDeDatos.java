
package Modelos;

/**
 * Clase hija de la super clase Asignatura
 * @author eduardolucasmunozdelucas
 */
public  class BaseDeDatos extends Asignatura{
    private String lenguaje;
    private String nivel;

    /**
     * Constructor de la clase BaseDeDatos
     * @param lenguaje
     * @param nivel
     * @param nombre
     * @param creditos 
     */
    public BaseDeDatos(String lenguaje, String nivel, String nombre, int creditos) {
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
        return super.toString()+ " ---> (Base de datos con: lenguaje = " + lenguaje + "; nivel = " + nivel+")." ;
       
    }

    
    /**
     * Metodo heredado y sobreescrito de la clase Asignatura que calcula el precio del total de creditos del objeto Base de datos.
     * @return double
     */
    @Override
    public double calcularPrecioTotal() {
        double precioCredito = 6.4;
        double precioTotal = this.getCreditos() * precioCredito;
        return precioTotal;
//        throw new UnsupportedOperationException("Not supported yet."); 
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    /**
     * Método heredado y sobrescrito que imprime la información de los objetos bases de datos.
     */
    @Override
    public void mostrarInformacion2() {
        System.out.println("Nombre: "+getNombre());
        System.out.println("Créditos: "+getCreditos());
        System.out.println("Nivel: "+getNivel());
        System.out.println("Lenguaje: "+ getLenguaje());
        System.out.println("Precio : "+calcularPrecioTotal() +" €");

    }
    
    
    
    /*
    /*
    Conjunto de getters y setters de la clase Asignatura
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
