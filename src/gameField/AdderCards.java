package gameField;

import command.console.Console;

import java.util.Scanner;

/**
 * Add cards to the game
 */

public class AdderCards {
    Console console = new Console();


    /**
     * Input value of pairs to generate
     * @return
     */
    public int numberOfPairs() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Enter the number of pairs you want to generate");
        System.out.print(">> ");
        int countOfPairs = sc.nextInt();
        console.saveCommand(String.valueOf(countOfPairs));
        return countOfPairs;
    }

    /**
     * Generate field of the game
     * @param cOP Number of pairs
     * @return fully loaded field
     */
    public String addCard(int cOP) {
        GenerateField gf = new GenerateField();
        gf.generateField(cOP);
        return "";
    }
}