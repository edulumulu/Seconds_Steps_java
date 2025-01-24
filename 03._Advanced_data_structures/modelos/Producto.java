
package modelos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author edulumulu
 */
public class Producto {
    
    private String nombre; //final??
     private ArrayList <String> materiales;
     private double precio;
     private int cantidad ;

     public Producto(String nombre) {
        this.nombre = nombre;
    }
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        
    }
     
    public Producto(String nombre, ArrayList<String> materiales, double precio, int cantidad) {
        this.nombre = nombre;
        this.materiales = materiales;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
     //Métodos sobreescritos 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return  "(hashCode=" + hashCode() + "), nombre=" + nombre + ", precio=" + precio +
                "€, cantidad=" + cantidad+ " ud, materiales=" + materiales.toString() +".";
       
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<String> materiales) {
        this.materiales = materiales;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
     
}
