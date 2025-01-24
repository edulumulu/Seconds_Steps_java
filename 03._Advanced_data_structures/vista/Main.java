
package vista;

import static Controlador.Controlador.actualizarProducto;
import static Controlador.Controlador.agregarProducto;
import static Controlador.Controlador.eliminarProducto;
import Controlador.EscepcionesMias;
import java.util.ArrayList;
import java.util.HashMap;
import static miLibreria.ValidDat.enteroEntreDosValores;
import modelos.Producto;

/**
 *
 * @author edulumulu
 */
public class Main {

    public static HashMap<String, Producto> listaProductos = new HashMap<>();

    /**
    *Imprime por pantalla un menú con las opciones
    */
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

    /**
     * Recorre el mapa lista de productos
     */
    public static void recorrerlista() {
        System.out.println(" ");
        System.out.println("--- LISTA DE PRODUCTOS ACTUALES ---");
        int contador = 1;
        if (!listaProductos.isEmpty()) {
            for (String k : listaProductos.keySet()) {
                System.out.println("Producto " + contador + " --->  Código: " + k + " " + listaProductos.get(k));
                contador++;
            }
        } else {
            System.out.println("Ninguno");
        }

        System.out.println(" ");
    }

    /**
     * Rellena de forma predeterminada cuatro ocurrencias en el mapa lista de Productos
     */
    public static void rellenarListaPredeterminada() {
        ArrayList<String> mat = new ArrayList<>();
        mat.add("Algodon");
        mat.add("Piel");
        listaProductos.put("casa", new Producto("casa", mat, 500000, 2));
        listaProductos.put("coche", new Producto("coche", mat, 20000.7, 14));
        listaProductos.put("falda", new Producto("falda", mat, 10.9, 100));
        listaProductos.put("valda", new Producto("valda", mat, 25.7, 5));
    }

    /**
     * Primero muestra los productos insertados, luego t permite elegir una opción y llama alos distintos metodos con un switch. 
     * Mientras no se salga con una opcíon se mantiene le bucle en el que muestra el menú para que elija una opción
     * @param args
     * @throws EscepcionesMias 
     */
    public static void main(String[] args) throws EscepcionesMias {
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
                    agregarProducto();

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
