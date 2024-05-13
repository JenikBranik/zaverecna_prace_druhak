package gameFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class checkerPairs {
    addingPairs aP = new addingPairs();

    public void checker(int countOfPairs) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        System.out.println("Enter row and column: ");
        row = scanner.nextInt();
        column = scanner.nextInt();
        guessPosition gP = new guessPosition(row, column);
        for (int i = 0; i < countOfPairs; i++) {
            compareGuess(countOfPairs, gP, aP.genPairs.get(i));
        }
    }


    public static String compareInput(String inputString, int row, int column, ArrayList<Pairs> arrayList) {
        for (guessPosition gP : arrayList) {
            if (triple.getString().equals(vstupniString) && triple.getInt1() == vstupniInt1 && triple.getInt2() == vstupniInt2) {
                return triple.getSymbol(); // Vrátit odpovídající symbol
            }
        }
        return "Symbol nenalezen"; // Pokud se shoda nenajde
    }


    public String compareGuess(int countOfPairs,guessPosition gP,Pairs p) {
        for (int i = 0; i < countOfPairs*2; i++) {
            if (p.row == gP.row && p.col == gP.column) {
                p.isGuessed = true;
                return p.symbol;
            }
        }
        return null;
    }
}
