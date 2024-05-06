import command.console.Console;
import gameField.AdderCards;
import gameFunctions.generatePairs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        generatePairs gP = new generatePairs();
        gP.setGeneratedPairs(10);
    }
}