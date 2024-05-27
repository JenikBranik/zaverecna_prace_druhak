package gameField;

import gameFunctions.Pairs;
import gameFunctions.addingPairs;
import gameFunctions.checkerPairs;

import java.util.Scanner;

public class Field {
    public static final String space = " ";
    checkerPairs cp = new checkerPairs();
    addingPairs aP = new addingPairs();
    boolean[][] odkrytePozice;  // Dvourozměrné pole pro sledování odkrytých pozic
    int[][] pocitadloOdkryti;   // Dvourozměrné pole pro sledování počtu odkrytí pozic
    int addCard;
    String nextSymbol;
    int firstGuessRow, firstGuessCol;

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

            if (firstGuessRow == 0) {
                firstGuessRow = guessedRow;
                firstGuessCol = guessedCol;
            } else {
                // Zde voláme metodu checkPair a předáváme jí souřadnice obou symbolů
                if (!checkPair(firstGuessRow, firstGuessCol, guessedRow, guessedCol)) {
                    // Pokud symboly nejsou shodné, zobrazení hracího pole zůstane nezměněno
                    odkrytePozice[firstGuessRow][firstGuessCol] = false;
                    odkrytePozice[guessedRow][guessedCol] = false;
                }
                // Resetujeme první tip
                firstGuessRow = 0;
                firstGuessCol = 0;
            }

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
                    if (odkrytePozice[row][col]) {
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

    // Metoda pro kontrolu dvou vybr0aných symbolů
    private boolean checkPair(int firstRow, int firstCol, int secondRow, int secondCol) {
        String symbol1 = getSymbolAt(firstRow, firstCol);
        String symbol2 = getSymbolAt(secondRow, secondCol);
        return symbol1.equals(symbol2);
    }
}