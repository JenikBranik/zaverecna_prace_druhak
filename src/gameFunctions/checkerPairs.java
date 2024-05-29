package gameFunctions;

import command.console.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class checkerPairs {
    addingPairs aP = new addingPairs();
    ArrayList<guessPosition> tG = new ArrayList<>();
    Console console = new Console();


    public ArrayList<guessPosition> takeGuess() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Enter the number of the row in which your type is found");
        int row = sc.nextInt();
        console.saveCommand(String.valueOf(row));
        System.out.println(">> Enter the number of the column in which your type is found");
        int column = sc.nextInt();
        console.saveCommand(String.valueOf(column));
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