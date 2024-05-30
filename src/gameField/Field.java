package gameField;

import gameFunctions.AddingPairs;
import gameFunctions.CheckerPairs;
import gameFunctions.GuessPosition;
import Player.*;

import java.util.ArrayList;


/**
 * Class with field and some structures
 */
public class Field {

    public static final String space = " ";
    private CheckerPairs cp = new CheckerPairs();
    private AddingPairs aP = new AddingPairs();
    private CheckPairOnField CPOF = new CheckPairOnField(aP);
    private boolean[][] showedPosition;
    private boolean[][] removedPosition;
    private int addCard;
    private String nextSymbol;
    private GuessPosition firstGuess = null;
    public ArrayList<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    int guessedPairs = 0;

    /**
     *  Full logic about generation of field
     * @param countPairs Count of pairs
     * @param customSymbols Custom symbols to generation
     */
    public void generateField(int countPairs, ArrayList<String> customSymbols) {
        aP.setGenPairs(countPairs, customSymbols); // Použijeme novou metodu s uživatelskými symboly
        this.addCard = countPairs * 2;
        int rows = (addCard + 3) / 4;
        showedPosition = new boolean[rows + 1][5];
        removedPosition = new boolean[rows + 1][5];
    }

    /**
     * Add player to the game
     * @param name Name of players
     */

    public void addPlayer(String name) {
        players.add(new Player(name, players.size() + 1));
    }

    /**
     * Get current player
     * @return Player name
     */

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * Move on next player
     */

    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    /**
     * Game continuity check
     * @return
     */

    public boolean gameContinue() {
        if (players.isEmpty()) {
            System.out.println(">> Game cannot start without players.");
            return false;
        } else if (guessedPairs == addCard / 2) {
            return false;
        }

        return true;
    }

    /**
     * Show field of the game
     */

    public void showField() {
        try {
            cp.takeGuess();
            int guessedRow = cp.rowTG();
            int guessedCol = cp.colTG();
            GuessPosition currentGuess = new GuessPosition(guessedRow, guessedCol);

            if (showedPosition[guessedRow][guessedCol] || removedPosition[guessedRow][guessedCol]) {
                System.out.println(">> This position has already been guessed by someone before you, choose another one");
                return;
            }

            showedPosition[guessedRow][guessedCol] = true;

            if (firstGuess == null) {
                firstGuess = currentGuess;
            } else {
                if (!CPOF.checkPair(firstGuess, currentGuess)) {
                    showCurrentField();
                    try {
                        Thread.sleep(3000); // Zastavení kódu na 3 sekundy
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 50; i++) {
                        System.out.println(" ");
                    }
                    showedPosition[firstGuess.getRow()][firstGuess.getColumn()] = false;
                    showedPosition[guessedRow][guessedCol] = false;
                    nextPlayer();
                    System.out.println(">> It's your turn: " + getCurrentPlayer().getUsername());
                } else {
                    guessedPairs++;
                    System.out.println(getCurrentPlayer().getUsername() + " matched the correct pairs!");
                    getCurrentPlayer().setScore(getCurrentPlayer().getScore() + 1);
                    System.out.println(">> " + getCurrentPlayer().getUsername() + " your score is: " + getCurrentPlayer().getScore());
                    removedPosition[firstGuess.getRow()][firstGuess.getColumn()] = true;
                    removedPosition[guessedRow][guessedCol] = true;
                }
                firstGuess = null;
            }

            showCurrentField();

        } catch (Exception e) {
            System.out.println(">> An error occurred while displaying the field.");
        }
    }

    /**
     * Show current field
     */

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
                if (removedPosition[row][col]) {
                    nextSymbol = " ";
                } else if (showedPosition[row][col]) {
                    nextSymbol = CPOF.getSymbolAt(new GuessPosition(row, col));
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
