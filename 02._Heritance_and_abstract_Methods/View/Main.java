/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package View;

import Modelos.Asignatura;
import Modelos.BaseDeDatos;
import Modelos.Programacion;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Main {

    public static Asignatura[] asignaturas = new Asignatura[4];

    /**
     * Metodo que solicita un entero entre 1 y 3 mostrando un menú.
     * @return Entero
     */
    public static int solicitarOpcion() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        int num = -1;
        do {    //solicita un numero hasta que la booleana cambie a false.
            System.out.println("""
                           
                           ------ Elige una de las opciones ----------
                           (1) Mostrar contenido utilizando MostrarInformación2 (Igual que ejemplo del enunciado). 
                           (2) Mostrar contenido utilizando MostrarInformación (Llamando al metodo .ToString sobreescrito).
                           (3) Salir del programa.
                           -------------------------------------------
                           Ingresa la opción deseada:
                           """);    
            try {       //Estructura de control de excepciones 
                num = sc.nextInt();
                if (num == 1 | num == 2 |num ==3) { // si cumple el if modifica ok a false
                    ok = false;
                } else {        // Si no muestra mnensaje de error
                    System.out.println("El numero debe ser 1, 2 o 3.");
                }
            } catch (InputMismatchException e) { // Si no se introduce un entero muiestra error
                System.out.println("El valor introducido no es correcto prueba otra vez");
                sc.next();
            }

        } while (ok);
        return num;
    }
    
    /**
     * Método Main, asigna valores a cuatro objetos asignatura, los guarda en el array asignaturas y muestra un menú 
     * para decidir como  se quieren ver los datos que contiene, según el metodo a utilizar. He probado hacer un metodo
     * e mostrar informacion n el que se llama a la función .To String modificada y oro mostrar información 2 en el que
     * se llama a una función heredada sin necesidad de usar .To String. Lo he hecho así para poner en práctica lo 
     * visto en clase.
     * @param args 
     */
    public static void main(String[] args) {

        asignaturas[0] = new Programacion("HTML", "Avanzado", "Lenguaje de Marcas", 100);
        asignaturas[1] = new BaseDeDatos("MySql", "Medio", "Base de Datos", 200);
        asignaturas[2] = new BaseDeDatos("Oracle", "Medio", "Tratamiento de Información", 200);
        asignaturas[3] = new Programacion("Java", "Medio", "Programación", 200);
        boolean ok = true;

        do {        //SOlicita un numero hasta que cambie la booleana a false
            
            int a = solicitarOpcion();  //Llamo al método solicitar opcion de la misma clase

            switch (a) {    //Estructura switch para mostrar opciones o salir.
                case 1:
                    for (int i = 0; i < asignaturas.length; i++) {
                        System.out.println("----- Asignatura " + (i + 1) + " -----");
                        asignaturas[i].mostrarInformacion2();
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    for (int i = 0; i < asignaturas.length; i++) {
                        System.out.println("Asignatura " + (i + 1));
                        System.out.println(asignaturas[i].mostrarInformacion(asignaturas[i]));
                        System.out.println("Precio total ---> " + asignaturas[i].calcularPrecioTotal()+" €");
                        System.out.println(" ");
                    }

                    break;
                case 3:
                    System.out.println("Muchas gracias por usar el programa. Adiós");
                    ok = false;
            }
        } while (ok);

        

    }
}
