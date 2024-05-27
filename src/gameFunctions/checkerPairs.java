package gameFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class checkerPairs {
    addingPairs aP = new addingPairs();
    ArrayList<guessPosition> tG = new ArrayList<>();


    public ArrayList<guessPosition> takeGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadej cislo radku, ve kterem se tvuj typ nachazi");
        int row = scanner.nextInt();
        System.out.println("Zadej cislo sloupce, ve kterem se tvuj typ nachazi");
        int column = scanner.nextInt();
        guessPosition gP = new guessPosition(row, column);
        tG.add(0, gP);
        return tG;
    }

    public int rowTG() {
        return tG.get(0).row;
    }

    public int colTG() {
        return tG.get(0).column;
    }
}