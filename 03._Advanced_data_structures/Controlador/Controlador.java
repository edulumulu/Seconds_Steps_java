package Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import static miLibreria.ValidDat.correctName;
import static miLibreria.ValidDat.pedirNumeroDecimal;
import static miLibreria.ValidDat.pedirNumeroEntero;
import static miLibreria.ValidDat.textoNoVacio;
import modelos.Producto;
import static vista.Main.listaProductos;
import static vista.Main.recorrerlista;

/**
 *
 * @author edulumulu
 */
public class Controlador {

    /**
     * El método agrega un nuevo producto comprobando que el nombre del producto no exita previamente
     * y lo guarda en el Mapa listaProductos.
     * 1.Solicito en nombre y lo comparo con las keys del hashmap listaProductos.
     * 2. Si ya existe vuelvo a pedir nombre, si no, solicito precio y cantidad.
     * 3. solicito los materiales mediante un bucle que sigue solicitando Strings y guardándolos en un arrayList hasta que se escriba "fin".
     * 4. Cuando el usuario escribe "fin", introduzco los valores solicitados a listaProductos poniendo el nombre como clave y creando un nuevo producto 
     * con los datos solicitados.
     * 5. Finalmente muestro por pantalla el listado de productos.
     */
    public static void agregarProducto() {
        boolean ok = true;

        System.out.println("--- AGREGAR PRODUCTO ---"); 

        do {
            System.out.print("Ingresa el nombre del producto: ");
            String nombre = textoNoVacio();

                if (listaProductos.containsKey(nombre)) {
                    System.out.println("El producto ya existe.");
                } else {
                    double precio = pedirNumeroDecimal();
                    int cantidad = pedirNumeroEntero();

                    ArrayList<String> materiales = new ArrayList<>();
                    String material;
                    System.out.println("Ingrese los materiales del producto (ingrese 'fin' para terminar): ");
                    boolean yes = true;
                    int contadorMaterial = 1;
                    do {
                        System.out.print("Material " + contadorMaterial + ": ");
                        material = correctName(textoNoVacio());
                        contadorMaterial++;
                        if (!material.equalsIgnoreCase("Fin")) {
                            materiales.add(material);
                        } else {
                            yes = false;
                        }
                    } while (yes);

                    listaProductos.put(nombre, new Producto(nombre, materiales, precio, cantidad));
                    ok = false;

                    System.out.println("Producto agregado exitosamente.");
                    recorrerlista();

                }

        } while (ok);
    }

    
    
    /**
     * Elimina un producto si el nombre del producto existe.
    * 1. Solicito al usuario que ingrese el nombre del producto que desea eliminar.
    * 2. Verificosi el producto existe en la lista de productos. Si no, se muestra un mensaje de error y se solicita al usuario que lo intente de nuevo.
    * 3. Si el producto existe, recoro los elementos de listaProductos utilizando un iterador. 
    * Comparo la key (nombre) del producto en cada entrada con dato introducido.
    * 4. Si existe el producto con el nombre correspondiente, lo elimino (iterator.remove()).
    * * 5. Finalmente muestro por pantalla el listado de productos.
     */
    public static void eliminarProducto(){
        if (listaProductos.isEmpty()) {
            System.out.println("""
                               
                               ¡Aun no hay productos! (el hashMap está vacío)
                               Puedes ingresar productos utilizando la opción (0) o (1).
                               """);
        } else {
            boolean ok = true;
            System.out.println("--- ELIMINAR PRODUCTO ---");

            do {
                System.out.print("Ingresa el nombre del producto: ");
                String nombre = textoNoVacio();
                if (listaProductos.containsKey(nombre)) {
                    
                    for (Iterator<Map.Entry<String, Producto>> iterator = listaProductos.entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<String, Producto> entry = iterator.next();

                        if (entry.getKey().equals(nombre)) {
                            System.out.println("Producto: " + entry.getKey() + " ---> Eliminado exitosamente");

                            iterator.remove(); // Eliminar el producto de la lista

                            break; // Salgo del bucle una vez que se elimina el producto
                        }
                    }
                    ok = false; 
                } else {
                    System.out.println("El producto no se encuentra en esta base de datos, Inténtalo de nuevo.");
                }
            } while (ok);

            recorrerlista();
        }

    }

    /**
     * Elimina un producto si el nombre del producto existe.
    * Mismo funcionamiento que el método anterior. 
    *En el caso de que el nombre dle producto esté en la BBDD le solicito un nuevo precio y una nueva cantidad.
    *finalmente con .replace modifico los valores del precio y cantidad manteniendo el reseto.
    */
    public static void actualizarProducto() {
        if (listaProductos.isEmpty()) {
            System.out.println("""
                               
                               ¡Aun no hay productos! 
                               Puedes ingresar productos utilizando la opción (0) o (1).
                               """);
         
        } else {
            boolean ok = true;
            System.out.println("--- ACTUALIZAR PRODUCTO ---");

            do {
                System.out.print("Ingresa el nombre del producto: ");
                String nombre = textoNoVacio();
                if (listaProductos.containsKey(nombre)) {
                    // Buscar el producto por key y eliminarlo de la lista

                    /*
            1. abajo
                     */
                    for (Iterator<Map.Entry<String, Producto>> iterator = listaProductos.entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<String, Producto> entry = iterator.next();

                        if (entry.getValue().getNombre().equals(nombre)) {
                            System.out.println("Producto seleccionado para actualizar:");
                            System.out.println("Producto: " + entry.getKey());
                            //System.out.println("materiales: "+ entry.getValue().getMateriales());

                            double nuevoPrecio = pedirNumeroDecimal();
                            int nuevaCantidad = pedirNumeroEntero();

                            listaProductos.replace(entry.getKey(), new Producto(entry.getValue().getNombre(), entry.getValue().getMateriales(), nuevoPrecio, nuevaCantidad));

                            break; // Salir del bucle una vez que se elimina el producto
                        }
                    }
                    ok = false; // Terminar el bucle
                } else {
                    System.out.println("El productoo no se encuentra en esta base de datos, Inténtalo de nuevo.");
                }
            } while (ok);

            recorrerlista();
        }
    }

}

