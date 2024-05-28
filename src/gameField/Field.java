package gameField;

import gameFunctions.addingPairs;
import gameFunctions.checkerPairs;
import gameFunctions.guessPosition;
import Player.*;

import java.util.ArrayList;

public class Field {
    public static final String space = " ";
    private checkerPairs cp = new checkerPairs();
    private addingPairs aP = new addingPairs();
    private CheckPairOnField CPOF = new CheckPairOnField(aP);
    private boolean[][] odkrytePozice;
    private int addCard;
    private String nextSymbol;
    private guessPosition firstGuess = null;
    public ArrayList<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    int guessedPairs = 0;

    public void generateField(int countPairs) {
        aP.setGenPairs(countPairs);
        this.addCard = countPairs * 2;
        int rows = (addCard + 3) / 4;
        odkrytePozice = new boolean[rows + 1][5];
    }

    public void addPlayer(String name) {
        players.add(new Player(name, players.size() + 1));
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public boolean gameContinue() {
        if (players.isEmpty()) {
            System.out.println("Hra nemůže začít bez hráčů.");
            return false;
        } else if (guessedPairs == addCard / 2) {
            return false;
        }

        return true;
    }

    public void showField() {
        try {
            cp.takeGuess();
            int guessedRow = cp.rowTG();
            int guessedCol = cp.colTG();
            guessPosition currentGuess = new guessPosition(guessedRow, guessedCol);

            if (odkrytePozice[guessedRow][guessedCol]) {
                System.out.println("Tuto pozici již někdo před tebou uhodl, vyber si jinou");
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
                    nextPlayer();
                    System.out.println("Na řadě je: " + getCurrentPlayer().getUsername());
                }else {
                    guessedPairs++;
                    System.out.println(getCurrentPlayer().getUsername() + " spojil spravne dvojice!");
                    getCurrentPlayer().setScore(getCurrentPlayer().getScore() + 1);
                    System.out.println("Tve skore je: " + getCurrentPlayer().getScore());
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