/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiLibreria;

import static Controlador.Gimanasio.clientes;
import static Controlador.Gimanasio.entrenadores;
import static MiLibreria.DatosArrays.estaVacio;
import static MiLibreria.Strings.palabraVacia;
import Modelos.Cliente;
import Modelos.Entrenador;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class ValidacionDatos {

    
    
    /**
     * Este metodo pide un numero por teclado y verifica que este entre los
     * valores a y b, si no se repite hasta que cumpla la condición.
     *
     * @param a --> Debe de ser un numero entero
     * @param b --> Debe de ser un numero entero
     * @return --> Retorna un el numero entero elegido en caso de cumplir la
     * restricción.
     */
    public static int enteroEntreDosValores(int a, int b) {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        int num = -1;
        do {
            try {
                num = sc.nextInt();
                if (num >= a && num <= b) {
                    ok = false;
                } else {
                    System.out.println("El valor debe estar comprendido entre: " + a + " y " + b + ":");
                    System.out.print("Vuelve a intentarlo:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Has introducido un dato invalido introduce un numero entre " + a + " y " + b + ".");
                System.out.print("Vuelve a intentarlo:");
                sc.next();
            }
        } while (ok);
        return num;
    }
    
    /**
     * Este metodo pide un numero por teclado y verifica que este entre los
     * valores a y b, si no se repite hasta que cumpla la condición.
     * @param a --> Debe de ser un numero entero
     * @param b --> Debe de ser un numero entero
     * @return --> Retorna un el numero entero elegido en caso de cumplir la
     * restricción.
     */
    public static int enteroEntreDosValores2(int a, int b) {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        int num = -1;
        do {
            try {
                num = sc.nextInt();
                if (num >= a && num <= b) {
                    ok = false;
                } else {
                    System.out.print("Ese código no está asociado, escribe otro: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Ese código no está asociado, escribe otro que sea numérico: ");
                sc.next();
            }
        } while (ok);
        return num;
    }
    
    public static boolean validarTelefono(int telefono) {
        // Verifica si el número de teléfono tiene exactamente 9 dígitos
        int contadorDigitos = 0;
        int temp = telefono;
        while (temp != 0) {
            temp /= 10;
            contadorDigitos++;
        }

        if (contadorDigitos == 9) {
            return true;
        } else {
            System.out.println("El número de teléfono debe tener exactamente 9 dígitos.");

            return false;
        }
    }

    public static int enteroNumTlf (){
         Scanner sc = new Scanner(System.in);
        int telefono = 0;

        do {
            try{
                System.out.print("TELÉFONO: ");
                telefono = sc.nextInt();
            }catch(InputMismatchException e){
                sc.next();
            }          
        } while (!validarTelefono(telefono));

        return telefono;
    }
    
    /**
     * Método para solicitar al usuario ingresar el dni con un patron determinado de numeros + letras.
     * @param numeros ---> entero
     * @param letras ---> entero
     * @return ---> Devuelve el String del usuario si cumple la condicion.
     */
    public static String leerDni(int numeros, int letras) {
        Scanner sc = new Scanner(System.in);
        String id;
        /*
        Next regex indicates a quantity of numbers(between 0 and 9) and a quantity 
        of characters (from A to Z uppercase and lowercase) indicated in parameters
         */
        String patron = "[0-9]{" + numeros + "}[A-z]{" + letras + "}";
        do {
            System.out.print("DNI: ");
            id = sc.nextLine();
            if (!Pattern.matches(patron, id)) {
                System.out.println("Incorrecto, no cumple el formato, deben ser "+numeros+" numeros y "+letras+" letras.");
                id = "";
            }
        } while (!Pattern.matches(patron, id));
        return id.toUpperCase();
    }
    
    

    /**
     * Metodo que para pedir numero entero positivo, en caso de ser mayor que 0
     * retorna el número.
     *
     * @return
     */
    public static int enteroPositivo() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        int num = -1;

        do {
            try {
                num = sc.nextInt();
                if (num > 0) {
                    ok = false;
                } else {
                    System.out.println("El número debe ser mayor que 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Has introducido un dato invalido introduce un numero mayor que 0");
                sc.next();
            }
        } while (ok);
        return num;
    }


    /**
     * Metodo que pide por teclado un texto, hasta que no verifica que hay algún
     * caracter no sale del bucle
     *
     * @return ---> Devuelve texto introducido.
     */
    public static String textoNoVacio() {
        Scanner sc = new Scanner(System.in);
        String texto = null;
        do {
//            System.out.println("Escribe un texto:");
            texto = sc.nextLine();
        } while (palabraVacia(texto));

        return texto;
    }

    /**
     * Solicita por teclado un entero. Si es 1 o 2 lo devuelve como valor de
     * salida, si no hace un bucle hasta que sea uno de esos dos numeros.
     *
     * @return ---> Devuelve entero.
     */
    public static int enteroDosOpciones() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        int op = -1;
        do {
            try {
                op = sc.nextInt();
                if (op == 1) {
                    ok = false;
                } else if (op == 2) {
                    ok = false;
                } else {
                    System.out.println("La opcion no es validad, debe de ser 1 o 2");
                    System.out.print("Vuelve a intentarlo:");
                }
            } catch (InputMismatchException e) {
                System.out.println("La opcion no es validad, debe de ser 1 o 2");
                System.out.print("Vuelve a intentarlo:");
                sc.next();
            }
        } while (ok);
        return op;
    }

    /**
     * Metodo utilizado ara convertir la opcion de numero entero seleccionada en
     * membresía a un string. En caso de no coincidir devuelve"---".
     *
     * @param a ---> Numero entero
     * @return
     */
    public static String leerMembresia(int a) {
        String texto = "----";
        if (a == 1) {
            texto = "Básica";
        }
        if (a == 2) {
            texto = "Premium";
        }
        return texto;
    }

    /**
     * Metodo utilizado para leer por teclado valores char correspondientes a la
     * seleccion de género. tres opciones ya se utilicen mayusculas o minúsculas
     *
     * @return ---> devuelve el valor intru¡oducido por teclado en caso de ser
     * correcto.
     */
    public static char readCharTresValores() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        char op;
        do {
            op = sc.nextLine().charAt(0);

            try {
                if (op == 'M' | op == 'm') {
                    ok = false;
                } else if (op == 'F' | op == 'f') {
                    ok = false;
                } else if (op == 'N' | op == 'n') {
                    ok = false;
                } else {
                    System.out.println("La opción elegida no es válida, debes elegir entre (M / F / N).");
                    System.out.print("Vuelve a intentarlo. MEMBRESÍA: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, debe de ser una de los tres (M / F / N)");
                System.out.print("Vuelve a intentarlo. MEMBRESÍA: ");
            }
        } while (ok);
        return op;
    }

    /**
     * Metodo utilizado para comparar el caracter introducido de género con su
     * String correspondiente
     *
     * @param op ---> Variable char
     * @return ---> Devuelve un String con las distitntas opciones, en caso de
     * no coincidir devuelve "----".
     */
    public static String readCharGenero(char op) {
        String text = "----";

        if (op == 'M' | op == 'm') {
            text = "Masculino";
        } else if (op == 'F' | op == 'f') {
            text = "Femenino";
        } else if (op == 'N' | op == 'n') {
            text = "Neutro";
        }
        return text;
    }

    /**
     * Metodo utilizado para comprobar el nombre del entrenador en caso de que
     * el objeto entrenador correspondiente esté lleno, si no devuelve un string
     * "ninguno".
     *
     * @param train ---> objeto de entrada Entrenador
     * @return o nombre de entrenador o "ninguno".
     */
    public static String entrenadorCliente(Entrenador train) {
        String text;
        if (train != null) {
            text = train.getNombre();
            return text;
        }
        text = "ninguno";
        return text;
    }

   /**
    * Función que comprueba si clientes está vacío y entrenadores, si no es así recorre el array clientes buscando la coincidencia del código
    * introducido como párametro con el codigo del objeto trainer de cada cliente, si coincide imprime el nombre del cliente.
    * @param num ---> numero entero
    */

        public static void clientesDeEntrenador2(int num) {
        String[] clientesDeEntrenador = new String[clientes.length];
        if (!estaVacio(clientes)) {
            if (!estaVacio(entrenadores)) {
                int contador = 0;
                for (Cliente cliente : clientes) {
                    if (cliente != null && cliente.trainer != null && cliente.trainer.getCodigo() == num) {
                        clientesDeEntrenador[contador++] = cliente.getNombre();
                        System.out.println("- " + cliente.getNombre());
                    }  
                }
            }
        }
    }   
}
