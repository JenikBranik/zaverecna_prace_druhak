package gameField;

import gameFunctions.Pairs;
import gameFunctions.addingPairs;
import gameFunctions.checkerPairs;
import gameFunctions.guessPosition;

import java.util.ArrayList;
import java.util.Scanner;

public class Field {
    public static final String space = " ";
    String nextSymbol = "~";
    checkerPairs cp = new checkerPairs();
    addingPairs aP = new addingPairs();
    boolean[][] odkrytePozice;  // Dvourozměrné pole pro sledování odkrytých pozic


    public void generateField(int countPairs) {
        aP.setGenPairs(countPairs); // Inicializace pole odkrytých pozic
    }


    public void showField(int addCard) {

        Scanner scanner = new Scanner(System.in);
        cp.takeGuess();
        int guessedRow = cp.rowTG();
        int guessedCol = cp.colTG();
        odkrytePozice[guessedRow][guessedCol] = true; // Nastavení aktuální pozice jako odkryté


        for (int column = 0; column < 5; column++) {
            if (column == 0) {
                System.out.print(space.repeat(4));
            } else {
                System.out.print(column + space.repeat(3));
            }
        }
        System.out.println();
        System.out.println();
        for (int row = 1; row <= addCard / 2; row++) {
            if (row >= 10) {
                System.out.print(row + space.repeat(2));
            } else {
                System.out.print(row + space.repeat(3));
            }
            for (int col = 1; col <= 4; col++) {
                if (odkrytePozice[row][col]) {
                    nextSymbol = cp.symbol(aP.genPairs); // Zobrazení symbolu pokud je pozice odkrytá
                }
                System.out.print(nextSymbol + space.repeat(3));
                nextSymbol = "~";
            }

            System.out.println();
            System.out.println();
        }
        if (addCard % 2 != 0) {

            if (addCard / 2 > 10 && addCard / 2 < 10) {
                System.out.print(addCard / 2 + 1 + space.repeat(2));
            } else {
                System.out.print(addCard / 2 + 1 + space.repeat(3));
            }
            System.out.print(nextSymbol + space.repeat(3));
            System.out.print(nextSymbol + space.repeat(3));
        }
    }
}

