/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author eduardolucasmunozdelucas
 */
public class Controlador {

    public static boolean verificarCodigoProducto(String codigo) {
        boolean ok = false;
        if (listaProductos.containsKey(codigo)) {
            ok = true;
        }
        return ok;
    }
//       boolean ok = false;
//          for (Producto producto : listaProductos.values()) {
//            if (producto.hashCode().equalsIgnoreCase(codigo)) {
//                ok = true;
//                
//            }
//            return ok;
//    }

    /*
    1.	Agregar producto: Solicita al usuario ingresar el nombre, precio y cantidad del producto. 
    Verifica si el producto ya existe en la lista utilizando los métodos equals() y hashCode(). 
    Si el producto ya existe, muestra un mensaje "El producto ya existe". 
    De lo contrario, crea un objeto Producto con los datos ingresados y agrégalo a listaProductos.
     */
    public static void agregarProducto1() {
        boolean ok = true;

        System.out.println("--- AGREGAR PRODUCTO ---");

        do {
            System.out.print("Ingresa el nombre del producto: ");
            String nombre = textoNoVacio();

            // esto es igual que constainValue
//            public static boolean verificarExistenciaProducto(String nombre) {
//        boolean ok = false;
//        for (Producto producto : listaProductos.values()) {
//            if (producto.getNombre().equalsIgnoreCase(nombre)) {
//                ok = true;
//
//            }
//        }
//        return ok;
//    }
            if (listaProductos.containsValue(new Producto(nombre))) {
                System.out.println("El producto ya existe.");
                //Si hay productos en la lista  comparo si el nombre existe
            } else {   //Si no directamente agrego producto

                agregarProducto2(nombre);
                ok = false;

            }

        } while (ok);
    }

    public static void agregarProducto2(String nombre) {
        boolean ok = true;
        do {
            System.out.print("Ingresa el código del producto: ");
            String codigo = textoNoVacio();

            //Ver metodo contains qu es el correcto
            if (listaProductos.containsKey(codigo)) {
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

                listaProductos.put(codigo, new Producto(nombre, materiales, precio, cantidad));
                ok = false;

                System.out.println("Producto agregado exitosamente.");
                recorrerlista();

            }
        } while (ok);
    }

    /*
    En este código:

Se solicita al usuario que ingrese el nombre del producto que desea eliminar.
Se verifica si el producto existe en la lista de productos.
Si el producto existe, se itera sobre los elementos de listaProductos utilizando un iterador. Se compara el nombre del producto en cada entrada con el nombre proporcionado por el usuario.
Si se encuentra el producto con el nombre correspondiente, se elimina utilizando el iterador (iterator.remove()).
Se imprime un mensaje de éxito y se sale del bucle.
Si el producto no se encuentra en la lista de productos, se muestra un mensaje de error y se solicita al usuario que lo intente de nuevo.
     */
    public static void eliminarProducto() {
         if(listaProductos.isEmpty()){
            System.out.println("""
                               
                               ¡Aun no hay productos! 
                               Puedes ingresar productos utilizando la opción (0) o (1).
                               """);
         }else{
             boolean ok = true;
        System.out.println("--- ELIMINAR PRODUCTO ---");

        do {
            System.out.print("Ingresa el nombre del producto: ");
            String nombre = textoNoVacio();
            if (listaProductos.containsValue(new Producto(nombre))) {
                // Buscar el producto por su nombre y eliminarlo de la lista

                /*
            1. abajo
                 */
                for (Iterator<Map.Entry<String, Producto>> iterator = listaProductos.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<String, Producto> entry = iterator.next();

                    if (entry.getValue().getNombre().equals(nombre)) {
                        System.out.println("Producto: " + entry.getValue() + " ---> Eliminado exitosamente");

                        iterator.remove(); // Eliminar el producto de la lista

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

    public static void actualizarProducto() {
        if(listaProductos.isEmpty()){
            System.out.println("""
                               
                               ¡Aun no hay productos! 
                               Puedes ingresar productos utilizando la opción (0) o (1).
                               """);
        }else{
             boolean ok = true;
        System.out.println("--- ACTUALIZAR PRODUCTO ---");

        do {
            System.out.print("Ingresa el nombre del producto: ");
            String nombre = textoNoVacio();
            if (listaProductos.containsValue(new Producto(nombre))) {
                // Buscar el producto por su nombre y eliminarlo de la lista

                /*
            1. abajo
                 */
                for (Iterator<Map.Entry<String, Producto>> iterator = listaProductos.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<String, Producto> entry = iterator.next();

                    if (entry.getValue().getNombre().equals(nombre)) {
                        System.out.println("Producto seleccionado para actualizar:");
                        System.out.println("Producto: " + entry.getValue());
//                        System.out.println("materiales: "+ entry.getValue().getMateriales());

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

/*
    Claro, esa línea de código se utiliza para iterar sobre los elementos de un Map, en este caso, listaProductos. Vamos a analizarla paso a paso:

listaProductos.entrySet(): Esto devuelve un conjunto de entradas (Entry) en el Map. Cada entrada contiene tanto la clave como el valor asociado en el Map. En este caso, la clave es un String (el código del producto) y el valor es un objeto Producto.
.iterator(): Llama al método iterator() en el conjunto de entradas para obtener un iterador sobre estas entradas. Un iterador es un objeto que permite recorrer secuencialmente una colección de elementos. En este caso, obtendrás un iterador sobre las entradas del Map.
Iterator<Map.Entry<String, Producto>> iterator = ...: Aquí estamos declarando e inicializando un nuevo iterador. El tipo entre los signos de mayor y menor (<>) especifica el tipo de cada elemento que se iterará. En este caso, cada elemento es una entrada del tipo Map.Entry<String, Producto>, donde la clave es un String y el valor es un Producto.
iterator.hasNext(): Este es el ciclo de iteración. El método hasNext() verifica si hay más elementos en la colección que aún no se han recorrido. Si este método devuelve true, significa que todavía hay elementos por iterar, y el ciclo continúa. Si devuelve false, significa que ya no hay más elementos y el ciclo termina.
Map.Entry<String, Producto> entry = iterator.next(): Aquí obtenemos la siguiente entrada del Map utilizando el iterador. El método next() devuelve la siguiente entrada en la colección y avanza el iterador al siguiente elemento. Cada vez que se llama a next(), el iterador se mueve al siguiente elemento en la colección y devuelve la entrada asociada a ese elemento.
En resumen, esta línea de código inicializa un iterador sobre las entradas del Map listaProductos, luego verifica si hay más elementos por recorrer y, si es así, obtiene la siguiente entrada del Map y la almacena en la variable entry. Esto permite recorrer cada par clave-valor en el Map.
 */
