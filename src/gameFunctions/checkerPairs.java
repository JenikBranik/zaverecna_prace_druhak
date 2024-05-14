package gameFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class checkerPairs {
    addingPairs aP = new addingPairs();
    ArrayList<guessPosition> tG = new ArrayList<>();

    public boolean checker(String symbol1, String symbol2, ArrayList<Pairs> genP) {
        if (symbol1.equals(symbol2)){
            for (int i = 0; i < genP.size(); i++) {
                if (genP.get(i).getSymbol().equals(symbol1)){
                    genP.get(i).setGuessed(true);
                }
            }
            return true;
        }
        return false;
    }

    public String symbol(ArrayList<Pairs> genP) {
        for (int i = 0; i < genP.size(); i++) {
            if (genP.get(i).row == rowTG() && genP.get(i).col == colTG()) {
                return genP.get(i).symbol;
            }
        }
        return null;
    }

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