package gameField;

import gameFunctions.Pairs;
import gameFunctions.addingPairs;
import gameFunctions.checkerPairs;
import gameFunctions.guessPosition;

import java.util.ArrayList;
import java.util.Scanner;

public class Field {
    public static final String space = " ";
    checkerPairs cp = new checkerPairs();
    addingPairs aP = new addingPairs();
    boolean[][] odkrytePozice;  // Dvourozměrné pole pro sledování odkrytých pozic
    int[][] pocitadloOdkryti;   // Dvourozměrné pole pro sledování počtu odkrytí pozic
    int addCard;
    String nextSymbol;

    public void generateField(int countPairs) {
        aP.setGenPairs(countPairs); // Inicializace generovaných párů
        this.addCard = countPairs * 2; // Aktualizace počtu karet
        int rows = (addCard + 3) / 4; // Počet řádků (zaokrouhleno nahoru)
        odkrytePozice = new boolean[rows + 1][5]; // Inicializace pole odkrytých pozic
        pocitadloOdkryti = new int[rows + 1][5];  // Inicializace pole počtu odkrytí
    }

    public void showField() {
        try {
            Scanner scanner = new Scanner(System.in);
            cp.takeGuess();
            int guessedRow = cp.rowTG();
            int guessedCol = cp.colTG();
            odkrytePozice[guessedRow][guessedCol] = true; // Nastavení aktuální pozice jako odkryté
            pocitadloOdkryti[guessedRow][guessedCol]++; // Zvýšení počtu odkrytí pro tuto pozici

            for (int column = 0; column < 5; column++) {
                if (column == 0) {
                    System.out.print(space.repeat(4));
                } else {
                    System.out.print(column + space.repeat(3));
                }
            }
            System.out.println();
            System.out.println();

            for (int row = 1; row <= (addCard + 3) / 4; row++) {
                if (row >= 10) {
                    System.out.print(row + space.repeat(2));
                } else {
                    System.out.print(row + space.repeat(3));
                }
                for (int col = 1; col <= 4; col++) {
                    if ((row - 1) * 4 + col > addCard) break; // Pokud přesáhne počet karet
                    if (odkrytePozice[row][col] && pocitadloOdkryti[row][col] < 3) {
                        nextSymbol = getSymbolAt(row, col); // Zobrazení symbolu pokud je pozice odkrytá
                    } else {
                        nextSymbol = "~";
                    }
                    System.out.print(nextSymbol + space.repeat(3));
                }

                System.out.println();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Došlo k chybě při zobrazování hracího pole: " + e.getMessage());
        }
    }

    private String getSymbolAt(int row, int col) {
        for (Pairs pair : aP.genPairs) {
            if (pair.getRow() == row && pair.getCol() == col) {
                return pair.getSymbol();
            }
        }
        return "~";
    }

    private boolean isGuessed(ArrayList<Pairs> genPairs, int row, int col) {
        for (Pairs pair : genPairs) {
            if (pair.getRow() == row && pair.getCol() == col) {
                return pair.isGuessed();
            }
        }
        return false;
    }
}