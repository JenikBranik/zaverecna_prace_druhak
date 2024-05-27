package gameField;

import gameFunctions.addingPairs;
import gameFunctions.checkerPairs;
import gameFunctions.guessPosition;


public class Field {
    public static final String space = " ";
    private checkerPairs cp = new checkerPairs();
    private addingPairs aP = new addingPairs();
    private CheckPairOnField CPOF = new CheckPairOnField(aP);
    private boolean[][] odkrytePozice;
    private int addCard;
    private String nextSymbol;
    private guessPosition firstGuess = null;

    public void generateField(int countPairs) {
        aP.setGenPairs(countPairs);
        this.addCard = countPairs * 2;
        int rows = (addCard + 3) / 4;
        odkrytePozice = new boolean[rows + 1][5];
    }

    public void showField() {
        try {
            cp.takeGuess();
            int guessedRow = cp.rowTG();
            int guessedCol = cp.colTG();
            guessPosition currentGuess = new guessPosition(guessedRow, guessedCol);

            if (odkrytePozice[guessedRow][guessedCol]) {
                System.out.println("Tato pozice byla již uhodnutá, vyberte prosím jinou.");
                return;
            }

            odkrytePozice[guessedRow][guessedCol] = true;

            if (firstGuess == null) {
                firstGuess = currentGuess;
            } else {
                if (!CPOF.checkPair(firstGuess, currentGuess)) {
                    showCurrentField();
                    for (int i = 0; i < 4; i++) {
                        System.out.println(" ");
                    }
                    odkrytePozice[firstGuess.getRow()][firstGuess.getColumn()] = false;
                    odkrytePozice[guessedRow][guessedCol] = false;
                }
                firstGuess = null;
            }

            showCurrentField();

        } catch (Exception e) {
            System.out.println("Došlo k chybě při zobrazování hracího pole: " + e.getMessage());
        }
    }

    private void showCurrentField() {
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
                if ((row - 1) * 4 + col > addCard) break;
                if (odkrytePozice[row][col]) {
                    nextSymbol = CPOF.getSymbolAt(new guessPosition(row, col));
                } else {
                    nextSymbol = "~";
                }
                System.out.print(nextSymbol + space.repeat(3));
            }

            System.out.println();
            System.out.println();
        }
    }
}