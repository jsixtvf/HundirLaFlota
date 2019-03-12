/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1_hundirlaflota;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sixto
 */
public class HundirLaFlota {

    /**
     * @param args the command line arguments
     */
    static char[] flota = {'F', 'A', 'D', 'S', 'P'};

    public static void main(String[] args) {
        // TODO code application logic here
        //ClasePrueba cp= new ClasePrueba(); Esto es un a prueba de visibilidad de Clases.0000
        inicializarJuego();

        boolean jugar = true;
        while (jugar) {
            jugarFlota();
            tiradaMaquina();
        }

    }

//    private static void juego() {
//        menu();
//    }
//    private static void menu() {
//        System.out.println("Elige la opcion a elegir");
//        System.out.println("0. Inicia Juego");
//        int opcion = leerEntero();
//        switch (opcion) {
//            case 0:
//                inicializarJuego();
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            default:
//
//        }
//
//    }
    // PREPARAR JUEGO
    private static void inicializarJuego() {
        String[][] tablero, tablero2 = null;
        int tamany;
        int n_barcos = 0;
        int[] barcos = null;

        //'F','D','A','S','P'];
        Scanner sc = new Scanner(System.in);
        String jugador1, jugador2;
        System.out.println("Introduce el nombre del jugador 1");
        jugador1 = sc.next();
        System.out.println("Introduce el nombre del jugador 2");
        jugador2 = sc.next();
        sc.nextLine();
        System.out.println("Da el tamaño al tablero");
        tamany = sc.nextInt();

        while (tamany < 5) {
            System.out.println("El tablero ha de ser mayor que 5. Vuelve a dar un tamaño: ");
            tamany = sc.nextInt();
        }

        tablero = new String[tamany][tamany];
        tablero2 = new String[tamany][tamany];

        n_barcos = tamany - 2;

        barcos = new int[n_barcos]; // inciar el array de integers

        int aux = 0;
        for (int i = 0; i < n_barcos; i++) {
            barcos[i] = aux;

            aux++;

        }

        colocarBarcos(tablero, barcos); //, n_barcos

    }

    private static void colocarBarcos(String[][] tablero, int[] barcos) { //, int n_barcos
        String orientacionVertical = "";
        String orientacionHorizontal = "";

        for (int i = 0; i < barcos.length; i++) {

            System.out.println("Elige si quieres colocar en vertical u horizontal. Escribe v o h");
            String orientacion = leerString();

            if (orientacion == "v") {
                System.out.println("Elige si colocar arriba o abajo. Escribe arriba o abajo");
                orientacionVertical = leerString();
            }

            if (orientacion == "h") {
                System.out.println("Elige si colocar a izquierda o derecha. Escribe i o d");
                orientacionHorizontal = leerString();
            }

            System.out.println("Jugador1. Donde quieres colocar el barco de tamaño" + barcos[i]);
            System.out.println("Dinos la fila");

            int fila = leerEntero();
            System.out.println("Dinos la columna");
            int columna = leerEntero();

            boolean correcto = comprobarLimites(fila, columna, tablero, i,
                    orientacionVertical, orientacionHorizontal);

            

            while (!correcto) {
                System.out.println("Posicion incorrecta");
                System.out.println("Dinos la fila otra vez");
                fila = leerEntero();
                System.out.println("Dinos la columna otra vez");
                columna = leerEntero();
                correcto = comprobarLimites(fila, columna, tablero, i,
                        orientacionVertical, orientacionHorizontal);
            }
            
            comprobarOcupado(fila, columna, tablero);

            if (orientacion == "v") {

                if (orientacionVertical == "arriba") {
                    int p = 0;
                    for (int j = fila; j < fila + barcos[i]; j--) {
                        tablero[fila - p][columna] = String.valueOf(flota[i]);
                        p++;
                    }

                }
                if (orientacionVertical == "abajo") {

                    int p = 0;
                    for (int j = 0; j < fila + barcos[i]; j++) {
                        tablero[fila + p][columna] = String.valueOf(flota[i]);
                        p++;
                    }

                }
            } else {
                if (orientacionHorizontal == "d") {
                    int p = 0;
                    for (int j = columna; j < columna - barcos[i]; j--) {
                        tablero[fila][columna - p] = String.valueOf(flota[i]);
                        p++;
                        //System.out.println(j);
                    }

                }
                if (orientacionHorizontal == "i") {
                    int p = 0;
                    for (int j = columna; j <= columna + barcos[i]; j++) {
                        tablero[fila][columna + p] = String.valueOf(flota[i]);
                        p++;
                    }

                }
            }

        }

        imprimirTablero(tablero);
    }

    private static void imprimirTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                // if (tablero[i][j] == null) {
                tablero[i][j] = "[]";
                // }
                System.out.print(tablero[i][j]);

            }
            System.out.println();
        }
    }

    private static int leerEntero() {
        Scanner sc = new Scanner(System.in);
        int entero = 0;
        entero = sc.nextInt();
        return entero;
    }

    private static String leerString() {
        Scanner sc = new Scanner(System.in);
        String caracter = "";
        caracter = sc.next();
        return caracter;
    }

    private static boolean comprobarLimites(int fila, int columna, String[][] tab, int indice,
            String orientacionVertical, String orientacionHorizontal) {

        boolean correcto = true;

        while (fila < 0 && fila > tab.length - 1) {
            System.out.println("Introduce un valor correcto de fila otra vez");
            fila = new Scanner(System.in).nextInt();

        }

//        for (int i = 0; i <= fila + indice; i++) {
//            if (!tab[fila + i][columna].isEmpty()) {
//                contadorejeY++;
//            }
//        }
        while (columna < 0 && columna > tab.length - 1) {
            System.out.println("Introduce un valor correcto de fila otra vez");

            columna = new Scanner(System.in).nextInt();

        }

        // HORIZONTAL
        int contador = 0;

        if (orientacionHorizontal == "izquierda") {
            int i = columna;
            while (i > columna - indice && correcto) {
                if (!tab[fila][columna - contador].isEmpty()) {
                    correcto = false;
                }
                i--;
                contador++;
            }

        }

        if (orientacionHorizontal == "derecha") {
            int i = columna;
            while (i <= columna + indice && correcto) {
                if (!tab[fila][columna + contador].isEmpty()) {
                    correcto = false;
                }
                i++;
                contador++;
            }

        }

        // VERTICAL
        if (orientacionVertical == "arriba") {

            int i = fila;
            while (i > fila - indice && correcto) {
                if (!tab[fila - contador][columna].isEmpty()) {
                    correcto = false;
                }
                i--;
                contador++;
            }

        }

        if (orientacionVertical == "abajo") {
            int i = fila;
            while (i <= fila + indice && correcto) {
                if (!tab[fila + contador][columna].isEmpty()) {
                    correcto = false;
                }
                i++;
                contador++;
            }
        }

        return correcto;

    }

    private static void comprobarOcupado(int fila, int columna, String[][] tablero) {
        Scanner sc = new Scanner(System.in);

        while (!tablero[fila][columna].isEmpty()) {
            System.out.println("Fila no vacía, escribe otra casilla");
            fila = sc.nextInt();
            columna = sc.nextInt();
        }
    }

    // JUEGO
    private static void jugarFlota() {

        mostrarMenu();

    }

    private static void mostrarMenu() {

        boolean seguir = true;
        while (seguir) {
            menu2();
            int opcion;
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    mostrarTableroContricante();
                    break;
                case 2:
                    mostrarTablero();
                    break;
                case 3:
                    introducirTirada();
                    break;
                case 4:
                    seguir = false;
                    break;
            }
        }

    }

    private static void mostrarTableroContricante() {
    }

    private static void mostrarTablero() {
    }

    private static void introducirTirada() {
    }

    private static void menu2() {
        System.out.println("Escoge una de las 4 opciones. Escribe el número de la opción");
        System.out.println("1. Mostrar tablero contricante.");
        System.out.println("2. Muestra tu tablero");
        System.out.println("3. Haz tu tirada");
        System.out.println("4. Pasar la tirada");

    }

    private static void tiradaMaquina() {

    }

}
