/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1_hundirlaflota;

/**
 *
 * @author sixto
 *
 * Teoría se puede añadir proyectos a otros proyectos con click derecho sobre el
 * proyecto destino, y los cambios de uno se verán reflejados en el otro.
 *
 * Teoría import static mibiblioteca.Mibiblioteca.input. mibiblioteca es el
 * proyecto, Mibiblioteca es la clase, e input es el método importado. si el
 * metodo es static el import es : import static, de lo contrario solo sería:
 * import
 *
 */
public class pruebas {

    public static void main(String[] args) {
        String[][] tablero;

        tablero = new String[8][8];
        tablero[0][1] = "#";
        imprimirtablero(tablero);

    }

    public static void imprimirtablero(String[][] tablero) {

        for (int i = 0; i < tablero.length; i++) {
            if (i == 0) {
                System.out.print("   ");
            } else if (i == 1) {
                System.out.print(" |" + i + "| ");
            } else {
                System.out.print("|" + i + "| ");
            }
        }
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            String pos = String.valueOf(i);
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == null) {
                    tablero[i][j] = " ";
                }
                if (j == 0) {
                    tablero[i][j] = pos;
                    System.out.print("|" + tablero[i][j] + "| ");
                } else {
                    System.out.print("|" + tablero[i][j] + "|" + " ");
                }
            }
            System.out.println("");
        }
    }
}
