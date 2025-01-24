/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Cliente {
    
    private  String nombre;
    private  String dni;
    private  int edad;
    private  int telefono;
    private  String email;
    private  int membresia;
    private  char genero;
    
    public  Entrenador trainer;
    
    public static int contadorClientes;

    /**
     * Constructor de la clase Cliente con los siguientes parámetros a insertar
     * @param nombre
     * @param dni
     * @param edad
     * @param telefono
     * @param email
     * @param membresia
     * @param genero 
     */
    
     public Cliente(String nombre, String dni, int edad, int telefono, String email, int membresia, char genero) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.membresia = membresia;
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
   

    
    
}
