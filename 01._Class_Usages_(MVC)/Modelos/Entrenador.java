/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Entrenador {
    private String nombre;
    private int codigo;
    private int edad;
    private int telefono;
    private String email;
    private String especialidad;
    private int experiencia;
    public static Cliente[] clientesAsignados;
    
    public static int contatdorEntrenadores;

    /**
     * Constructor de la clase Entrenador con los siguientes parámetros:
     * @param codigo
     * @param nombre
     * @param edad
     * @param telefono
     * @param email
     * @param especialidad
     * @param experiencia 
     */
    public Entrenador(int codigo, String nombre,  int edad, int telefono, String email, String especialidad, int experiencia) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    
    
    
    
}
