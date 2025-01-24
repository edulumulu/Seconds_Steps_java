/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static MiLibreria.DatosArrays.estaLleno;
import static MiLibreria.DatosArrays.estaVacio;
import static MiLibreria.DatosArrays.primeraPosicionLibre;
import static MiLibreria.ValidacionDatos.clientesDeEntrenador2;
import static MiLibreria.ValidacionDatos.enteroDosOpciones;
import static MiLibreria.ValidacionDatos.enteroEntreDosValores;
import static MiLibreria.ValidacionDatos.enteroEntreDosValores2;
import static MiLibreria.ValidacionDatos.enteroNumTlf;
import static MiLibreria.ValidacionDatos.entrenadorCliente;
import static MiLibreria.ValidacionDatos.leerDni;
import static MiLibreria.ValidacionDatos.leerMembresia;
import static MiLibreria.ValidacionDatos.readCharGenero;
import static MiLibreria.ValidacionDatos.readCharTresValores;
import static MiLibreria.ValidacionDatos.textoNoVacio;
import Modelos.Cliente;
import static Modelos.Cliente.contadorClientes;
import Modelos.Entrenador;
import static Modelos.Entrenador.contatdorEntrenadores;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Gimanasio {

    public static Cliente[] clientes = new Cliente[100];
    public static Entrenador[] entrenadores = new Entrenador[10];

    /**
     * Metodo que verifica con un true o un false si el String introducido
     * coincide con el dni de alguno de los clientes. Si es así avisa eu
     * necesitas otro dni, no es válido.
     *
     * @param dni ---> String
     * @return ---> true o false.
     */
    public static boolean validarDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente != null && dni.equals(cliente.getDni())) {
                System.out.println("El DNI ya existe, necesitas otro DNI.");
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que verifica con un true o un false si el entero introducido
     * coincide con el códifo de alguno de los entrenadores. Si es así avisa eu
     * necesitas otro código, no es válido.
     *
     * @param cod ---> entero
     * @return ---> true o false.
     */
    public static boolean validarCodigoEntrenador(int cod) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador != null && cod == entrenador.getCodigo()) {
                System.out.println("El código ya existe, necesitas otro código.");
                return false;
            } else {
            }
        }
        return true;
    }

    /**
     * Metodo que llama a otras funciones con la finalidad de agregar los
     * distintos campos introducidos por el usuario a un objeto cliente del
     * array clientes. En caso de ya existir el dni introducido lo vuelve a
     * solicitar. Finalmente si el array de clientes tiene espacio lo agrega.
     */
    public static void agregarCliente() {
        if (!estaLleno(clientes)) {
            String dni;
            do {
//                System.out.print("DNI: ");
                dni = leerDni(8, 1);
            } while (!validarDni(dni));

            System.out.print("NOMBRE:");
            String nombre = textoNoVacio();

            System.out.print("EDAD:");
            int edad = enteroEntreDosValores(15, 99);

            int tlf = enteroNumTlf();
            System.out.print("EMAIL:");
            String email = textoNoVacio();
            System.out.print("MEMBRESÍA (1. Básica / 2. Premium):");
            int membresia = enteroDosOpciones();
            System.out.print("GÉNERO (M / F / N):");
            char genero = readCharTresValores();

            int posicionLibre = primeraPosicionLibre(clientes);

            if (posicionLibre >= 0 && posicionLibre < clientes.length) {
                clientes[posicionLibre] = new Cliente(nombre, dni, edad, tlf, email, membresia, genero);
                System.out.println(" ");
                System.out.println("Cliente agregado correctamente.");
                contadorClientes++;
            }
        } else {
            System.out.println("El cupo está completo.");
        }
    }

    /**
     * Metodo que llama a otras funciones con la finalidad de agregar los
     * distintos campos introducidos por el usuario a un objeto entrenador del
     * array entrenadores. En caso de ya existir el código introducido lo vuelve
     * a solicitar. Finalmente si el array de entrenadores tiene espacio lo
     * agrega.
     */
    public static void agregarEntrenador() {
        if (!estaLleno(entrenadores)) {
            int cod;
            do {
                System.out.print("CÓDIGO: ");
                cod = enteroEntreDosValores(1, 10);
            } while (!validarCodigoEntrenador(cod));

            System.out.print("NOMBRE: ");
            String nombre = textoNoVacio();
            System.out.print("EDAD:");
            int edad = enteroEntreDosValores(18, 99);
            int tlf = enteroNumTlf();
            System.out.print("EMAIL:");
            String email = textoNoVacio();

            System.out.print("ESPECIALIDAD: ");
            String especialidad = textoNoVacio();
            System.out.print("AÑOS DE EXPERIENCIA: ");
            int expe = enteroEntreDosValores(0, 80);

            int posicionLibre = primeraPosicionLibre(entrenadores);

            if (posicionLibre >= 0 && posicionLibre < entrenadores.length) {
                entrenadores[posicionLibre] = new Entrenador(cod, nombre, edad, tlf, email, especialidad, expe);
                System.out.println(" ");
                System.out.println("Entrenador agregado correctamente.");
                contatdorEntrenadores++;
            }
        } else {
            System.out.println("No se precisan más entrenadores, el cupo está completo .");
        }
    }

    /**
     * Método que muestra información de los clientes siempre y cuando el array
     * clientes tenga objetos clientes añadidos.
     */
    public static void mostrarInfoClientes() {
        if (!estaVacio(clientes)) {
            System.out.println("Estos son los clientes registrados:");
            System.out.println(" ");

            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] != null) {

                    System.out.println("--- Cliente " + (i + 1) + " ---");
                    System.out.println("Nombre: " + clientes[i].getNombre());
                    System.out.println("DNI: " + clientes[i].getDni());
                    System.out.println("Edad: " + clientes[i].getEdad());
                    System.out.println("Email: " + clientes[i].getEmail());
                    System.out.println("Membresía: " + leerMembresia(clientes[i].getMembresia()));
                    System.out.println("Género: " + readCharGenero(clientes[i].getGenero()));
                    System.out.println("Entrenador asignado: " + entrenadorCliente(clientes[i].trainer));
                    System.out.println("     ------     ");
                    System.out.println(" ");

                } else {
                    
                }
            }
        } else {
            System.out.println("No hay ningún cliente en la lista.");
        }
    }

    /**
     * Método que muestra información de los entrenadores siempre y cuando el
     * array entrenadores tenga objetos entrenadores añadidos.
     */
    public static void mostrarEntrenadores() {
        
        if (!estaVacio(entrenadores)) {
            System.out.println("Estos son los Entrenadores del gimnasio:");

            for (int i = 0; i < entrenadores.length; i++) {

                if (entrenadores[i] != null) {

                    System.out.println("--- Entrenador " + (i + 1) + " ---");
                    System.out.println("Nombre: " + entrenadores[i].getNombre());
                    System.out.println("Código: " + entrenadores[i].getCodigo());
                    System.out.println("Edad: " + entrenadores[i].getEdad());
                    System.out.println("Email: " + entrenadores[i].getEmail());
                    System.out.println("Especialidad: " + entrenadores[i].getEspecialidad());
                    System.out.println("Años de experiencia: " + entrenadores[i].getExperiencia());
                    System.out.println("Clientes asignados: ");
                    clientesDeEntrenador2(entrenadores[i].getCodigo());
                    System.out.println("     ------     ");
                }
            }
        } else {
            System.out.println("No hay ningún entrenador en la lista.");
        }
    }

    /**
     * Método que sirve para asignar a cada cliente un entrenador. El método
     * verifica primero si los arrays clientes y entrenadores tienen
     * ocurrencias, si es así solicita al usuario el dni del cliente, si el dni
     * tiene alguna coincidencia enl array clientes llama a otro metodo
     * denominado segunda parte, si no informa de que el dni no está registrado
     * y lo vuelve a solicitar.
     */
    public static void asignarEntrenador() {
        
        if (!estaVacio(clientes)) {
            if (!estaVacio(entrenadores)) {
                String dniIntroducido;
                boolean ok = true;
                do {
                    System.out.print("Ingrese el DNI del cliente: ");
                    dniIntroducido = textoNoVacio();
                    int i = 0;
                    try {
                        while (clientes[i] != null && i <= clientes.length) {

                            if (clientes[i].getDni().equals(dniIntroducido)) {
                                ok = false;
                                segundaParte(i);
                                break;

                            } else {
                                i++;
                            }
                        }
                    }catch(ArrayIndexOutOfBoundsException e){ 
                        ok=true;
                    }
                }while (ok);
                
            } else {
                System.out.println("No se puede,no hay entrenadores todavía.");
            }
        } else {
            System.out.println("No se puede, todavía no hay inscritos clientes .");
        }
    }

    /**
     * Metodo utilizado como función dentro de asignar entrenador que consiste
     * en verificar si el código introducido como parámetro coincide con el
     * código de alguno de los objetos entrenador dentro del array entrenadores,
     * si es así, agrega el objeto entrenador coincidente al cliente
     * anteriormente identificado. En caso de que el código no coincida vuelve a
     * solicitarlo.
     *
     * @param posicion
     */
    public static void segundaParte(int posicion) {
        boolean yes = true;
        do {
            System.out.print("Ingresa el código del entrenador: ");
            int codIntroducido = enteroEntreDosValores2(1, entrenadores.length);
            int i = 0;

            while (entrenadores[i] != null && i < entrenadores.length) {

                if (codIntroducido == entrenadores[i].getCodigo()) {

                    clientes[posicion].trainer = new Entrenador(entrenadores[i].getCodigo(), entrenadores[i].getNombre(), entrenadores[i].getEdad(),
                            entrenadores[i].getTelefono(), entrenadores[i].getEmail(), entrenadores[i].getEspecialidad(), entrenadores[i].getExperiencia());
                    yes = false;
                    System.out.println("El entrenador ha sido agregado correctamente.");

                    System.out.println("el entrenador de " + clientes[posicion].getNombre() + " es: " + clientes[posicion].trainer.getNombre());
                    break;
                    
                } else {
                    i++;
                }
            }
        } while (yes);
    }
}
