/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import static Controlador.Controlador.actualizarProducto;
import static Controlador.Controlador.agregarProducto1;
import static Controlador.Controlador.eliminarProducto;
import java.util.ArrayList;
import java.util.HashMap;
import static miLibreria.ValidDat.enteroEntreDosValores;
import modelos.Producto;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Main {

    public static HashMap<String, Producto> listaProductos = new HashMap<>();

    public static void menu() {
        System.out.println("""
                           -------- MENU --------
                           0. Si quieres añadir una pila de Productos ya creada
                           1. Agregar porducto
                           2. Acualizar producto
                           3. Eliminar producto
                           4. Salir
                           ----------------------""");
    }
    
    public static void recorrerlista(){
        System.out.println(" ");
         System.out.println("--- LISTA DE PRODUCTOS ACTUALES ---");
                int contador = 1;
                for (String k : listaProductos.keySet()) {
                    System.out.println("Producto " + contador + " --->  Código: " + k + " " + listaProductos.get(k));
                    contador++;

                }
                System.out.println(" ");
    }
    
    public static void rellenarListaPredeterminada(){
        ArrayList <String> mat= new ArrayList<>();
        mat.add("Algodon");
        mat.add("Piel");
        listaProductos.put("2B", new Producto("casa",mat , 500000 , 2));
        listaProductos.put("1A", new Producto("coche",mat , 20000.7 , 14));
        listaProductos.put("8Z", new Producto("falda",mat , 10.9 , 100));
        listaProductos.put("3L", new Producto("valda",mat , 25.7 , 5));
    }

    public static void main(String[] args) {
        boolean ok = true;
        int opt;
        
        recorrerlista();
        
        
        do {
            menu();
            System.out.print("Inserta la opción deseada: ");
            opt = enteroEntreDosValores(0, 4);

            switch (opt) {
                case 0:
                    rellenarListaPredeterminada();
                    recorrerlista();
                    break;
                case 1:
                    agregarProducto1();

                    break;
                case 2:
                    actualizarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    System.out.println("Gracias por usar el programa.");
                    ok = false;
            }
        } while (ok);

    }
}
