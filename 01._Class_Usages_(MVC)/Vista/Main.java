/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import static Controlador.Gimanasio.agregarCliente;
import static Controlador.Gimanasio.agregarEntrenador;
import static Controlador.Gimanasio.asignarEntrenador;
import static Controlador.Gimanasio.mostrarEntrenadores;
import static Controlador.Gimanasio.mostrarInfoClientes;
import static MiLibreria.ValidacionDatos.enteroEntreDosValores;



/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Main {
    
    /**
     * Este metodo muestra el menú principal de esta aplicación.
     * No necesita ningún valor de entrada.
     */
    public static void menu (){
        System.out.println("""
                           
                           ----- Sistema de gestión del gimnasio -----
                           (1) Agregar clientes al gimnasio. 
                           (2) Agregar entrenadores al gimnasio.
                           (3) Agregar entrenador a cliente.
                           (4) Mostrar información de los clientes.
                           (5) Mostrar información de los entrenadores.
                           (6) Salir
                           -------------------------------------------
                           Ingresa la opción deseada:""");
    }
    
    public static void main(String[] args) {
        
        boolean ok = true;
        int opcion;
        
        do{
            menu();
            opcion = enteroEntreDosValores(1,6);
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    agregarEntrenador(); 
                    break;
                case 3:
                    asignarEntrenador();      
                    break;
                case 4:
                    mostrarInfoClientes();
                    break;
                case 5:
                    mostrarEntrenadores ();
                    break;
                case 6:
                    System.out.println("----- Gracias por usar el programa -----");
                    ok = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }while(ok);
    }
    
    
}
